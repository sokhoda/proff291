package hw7.springnotes.action;

import hw7.springnotes.domain.CPU;
import hw7.springnotes.domain.Memory;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.Menu;
import hw7.springnotes.service.NotebookService;
import hw7.springnotes.util.StartupListener;
import hw7.springnotes.util.Utils;
import hw7.springnotes.domain.Notebook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by v.davidenko on 15.02.2016.
 */

@WebServlet("/noteServlet")
public class NoteServlet extends HttpServlet {

    private NotebookService noteService;

    @Override
    public void init() throws ServletException {
        noteService = StartupListener.getBean("notebookService", NotebookService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Vendor> vendorList = noteService.getAllVendors();
        List<CPU> cpuList = noteService.getAllCPUs();
        List<Memory> memoryList = noteService.getAllMemories();

        Map<String, String[]> parameterMap = req.getParameterMap();
        String action = parameterMap.get("action")[0];

        if (action.equals("find")) {
            Long id = Long.valueOf(parameterMap.get("selectedId")[0]);
            Notebook note = noteService.getNotebookById(id);

            if (note == null) {
                req.setAttribute("selectedId",parameterMap.get("selectedId")[0]);
                req.setAttribute("server_msg", Menu.NO_SUCH_ENTITY_MSG);
            } else {
                req.setAttribute("id", String.valueOf(note.getId()));
                req.setAttribute("model", note.getModel());
                req.setAttribute("date", note.getManufactureDateStr());
                req.setAttribute("vendorId", String.valueOf(note.getVendor().getId()));
                req.setAttribute("cpuId", String.valueOf(note.getCpu().getId()));
                req.setAttribute("memoryId", String.valueOf(note.getMemory().getId()));
                req.setAttribute("vendorList", vendorList);
                req.setAttribute("cpuList", cpuList);
                req.setAttribute("memoryList", memoryList);
            }
            req.getRequestDispatcher(Menu.NOTEBOOK_PAGE).forward(req, resp);
            return;
        }

        if (action.equals("save")) {
            String id = parameterMap.get("id")[0];
            String model = parameterMap.get("model")[0].trim();
            Date date = Utils.stringToDate(parameterMap.get("date")[0].trim(), "dd.MM.yyyy");

            Long vendorId = Long.valueOf(parameterMap.get("vendorId")[0]);
            Vendor vendor = noteService.getVendorById(vendorId);
            Long cpuId = Long.valueOf(parameterMap.get("cpuId")[0]);
            CPU cpu = noteService.getCPUById(cpuId);
            Long memoryId = Long.valueOf(parameterMap.get("memoryId")[0]);
            Memory memory = noteService.getMemoryById(memoryId);

            Notebook note = new Notebook();
            note.setModel(model);
            note.setManufactureDate(date);
            note.setVendor(vendor);
            note.setCpu(cpu);
            note.setMemory(memory);

            if (id.isEmpty()) {
                if (!noteService.insertNotebook(note).equals(0L)) {
                    req.setAttribute("server_msg", Menu.ADD_SUCCESS_MSG);
                }
            } else {
                note.setId(Long.valueOf(id));
                if (noteService.updateNotebook(note)) {
                    req.setAttribute("server_msg", Menu.UPDATE_SUCCESS_MSG);
                }
            }
            Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
            for(Map.Entry<String, String[]> entry : entries) {
                req.setAttribute(entry.getKey(), entry.getValue()[0]);
            }
            req.setAttribute("vendorList", vendorList);
            req.setAttribute("cpuList", cpuList);
            req.setAttribute("memoryList", memoryList);

            req.getRequestDispatcher(Menu.NOTEBOOK_PAGE).forward(req, resp);
        }
    }
}
