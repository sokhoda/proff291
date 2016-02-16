package hw7.notes.service;

import hw7.notes.domain.Memory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by v.davidenko on 15.02.2016.
 */

@WebServlet("/memoryServlet")
public class MemoryServlet extends HttpServlet {

    final static String MEMORY_PAGE = "hw7/entity/memory.jsp";
    final static String UPDATE_SUCCESS_MSG = "Data updated successfully";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String id = parameterMap.get("entityId")[0];
        String vendorName = parameterMap.get("vendor")[0].trim();
        String size = parameterMap.get("size")[0].trim();

        Memory memory = new Memory();
        memory.setId(Long.valueOf(id));
        memory.setVendor(vendorName);
        memory.setSize(size);

        if (Menu.noteService.updateMemory(memory)) {
            req.setAttribute("server_msg", UPDATE_SUCCESS_MSG);
        }
        req.setAttribute("entityId", id);
        req.setAttribute("vendor", vendorName);
        req.setAttribute("size", size);
        req.getRequestDispatcher(MEMORY_PAGE).forward(req, resp);
    }
}
