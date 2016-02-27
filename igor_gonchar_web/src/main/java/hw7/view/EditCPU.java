package hw7.view;

import hw7.domain.CPU;
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
@WebServlet("/editCPU")
public class EditCPU extends HttpServlet {
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

        Long CPUId = Long.valueOf(parameterMap.get("cpuId")[0]);
        CPU cpu = notebookService.getCPUById(CPUId);

        String message = "";

        if (edit != null) {
            String vendor = parameterMap.get("vendor")[0];
            String frequency = parameterMap.get("frequency")[0];
            String model = parameterMap.get("model")[0];

            cpu.setVendor(vendor);
            cpu.setFrequency(frequency);
            cpu.setModel(model);

            notebookService.updateCPU(cpu);

            List<CPU> cpuList = notebookService.getAllCPUs();
            request.setAttribute("cpuList", cpuList);
        } else {
            notebookService.removeCPU(cpu);

            List<CPU> cpuList = notebookService.getAllCPUs();
            request.setAttribute("cpuList", cpuList);

            message = "CPU was deleted";
        }

        request.setAttribute("reg_result", message);
        request.getRequestDispatcher("/hw7/editCPU.jsp").forward(request, resp);

    }
}