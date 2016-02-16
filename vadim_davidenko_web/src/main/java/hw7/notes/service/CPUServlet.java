package hw7.notes.service;

import hw7.notes.domain.CPU;

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

@WebServlet("/cpuServlet")
public class CPUServlet extends HttpServlet {

    final static String CPU_PAGE = "hw7/entity/cpu.jsp";
    final static String UPDATE_SUCCESS_MSG = "Data updated successfully";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String id = parameterMap.get("entityId")[0];
        String model = parameterMap.get("model")[0].trim();
        String vendor = parameterMap.get("vendor")[0].trim();
        String freq = parameterMap.get("frequency")[0].trim();

        CPU cpu = new CPU();
        cpu.setId(Long.valueOf(id));
        cpu.setModel(model);
        cpu.setVendor(vendor);
        cpu.setFrequency(freq);

        if (Menu.noteService.updateCPU(cpu)) {
            req.setAttribute("server_msg", UPDATE_SUCCESS_MSG);
        }
        req.setAttribute("entityId", id);
        req.setAttribute("model", model);
        req.setAttribute("vendor", vendor);
        req.setAttribute("frequency", freq);
        req.getRequestDispatcher(CPU_PAGE).forward(req, resp);
    }
}
