package hw7.view;

import hw7.domain.CPU;
import hw7.domain.Memory;
import hw7.domain.Notebook;
import hw7.domain.Vendor;
import hw7.service.NotebookService;
import hw7.util.StartupListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by i.gonchar on 2/24/2016.
 */
@WebServlet("/editNotebook")
public class EditNotebook extends HttpServlet {
    private NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        notebookService = StartupListener.getBean("notebookService", NotebookService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String edit = request.getParameter("editButton");

        Long notebookId = Long.valueOf(parameterMap.get("notebookId")[0]);
        Notebook notebook = notebookService.getNotebookById(notebookId);

        String message = "";

        if (edit != null) {
            Long vendorId = Long.valueOf(parameterMap.get("vendorId")[0]);
            Vendor vendor = notebookService.getVendorById(vendorId);
            Long memoryId = Long.valueOf(parameterMap.get("memoryId")[0]);
            Memory memory = notebookService.getMemoryById(memoryId);
            Long CPUId = Long.valueOf(parameterMap.get("cpuId")[0]);
            CPU cpu = notebookService.getCPUById(CPUId);

            String model = parameterMap.get("model")[0];
            if (model != null) {
                notebook.setModel(model);
            }

            notebook.setCpu(cpu);
            notebook.setVendor(vendor);
            notebook.setMemory(memory);

            notebookService.updateNotebook(notebook);

            List<Notebook> notebookList = notebookService.getAllNotebooks();
            request.setAttribute("notebookList", notebookList);

            List<CPU> cpuList = notebookService.getAllCPUs();
            request.setAttribute("cpuList", cpuList);
            List<Vendor> vendorList = notebookService.getAllVendors();
            request.setAttribute("vendorList", vendorList);
            List<Memory> memoryList = notebookService.getAllMemories();
            request.setAttribute("memoryList", memoryList);
        } else {
            notebookService.removeNotebook(notebook);
            List<Notebook> notebookList = notebookService.getAllNotebooks();
            request.setAttribute("notebookList", notebookList);
            message = "Notebook was deleted";
        }

        String pageAddress = "/hw7/editNotebook.jsp";
        request.setAttribute("reg_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, resp);
    }
}