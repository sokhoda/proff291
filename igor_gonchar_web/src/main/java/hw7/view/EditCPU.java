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



        Long CPUId = Long.valueOf(parameterMap.get("cpuId")[0]);
        CPU cpu = notebookService.getCPUById(CPUId);





        request.setAttribute("reg_result", "CPU was edited");
        request.getRequestDispatcher("/hw7/editCPU.jsp").forward(request, resp);

    }
}