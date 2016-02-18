package hw7.notes.service;

import hw7.notes.domain.Memory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by v.davidenko on 15.02.2016.
 */

@WebServlet("/memoryServlet")
public class MemoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String action = parameterMap.get("actionId")[0];

        if (action.equals("find")) {
            Long id = Long.valueOf(parameterMap.get("selectedId")[0]);
            Memory memory = Menu.noteService.getMemoryById(id);
            if (memory == null) {
                req.setAttribute("selectedId",parameterMap.get("selectedId")[0]);
                req.setAttribute("server_msg", Menu.NO_SUCH_ENTITY_MSG);
            } else {
                req.setAttribute("id", String.valueOf(memory.getId()));
                req.setAttribute("vendor", memory.getVendor());
                req.setAttribute("size", memory.getSize());
            }
            req.getRequestDispatcher(Menu.MEMORY_PAGE).forward(req, resp);
            return;
        }

        if (action.equals("save")) {
            String id = parameterMap.get("id")[0];
            String vendor = parameterMap.get("vendor")[0].trim();
            String size = parameterMap.get("size")[0].trim();

            Memory memory = new Memory();
            memory.setId((!id.isEmpty()) ? Long.valueOf(id) : 0L);
            memory.setVendor(vendor);
            memory.setSize(size);

            if (Menu.noteService.updateMemory(memory)) {
                req.setAttribute("server_msg", Menu.UPDATE_SUCCESS_MSG);
            }
            Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
            for(Map.Entry<String, String[]> entry : entries) {
                req.setAttribute(entry.getKey(), entry.getValue()[0]);
            }
            req.getRequestDispatcher(Menu.MEMORY_PAGE).forward(req, resp);
        }
    }
}
