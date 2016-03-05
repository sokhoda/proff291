package hw7.view;

import hw7.domain.CPU;
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
 * Created by i.gonchar on 2/16/2016.
 */
@WebServlet("/addCPU")
public class AddCPU extends HttpServlet {
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
        String vendorName = parameterMap.get("vendorName")[0];
        String frequency = parameterMap.get("frequency")[0];
        String model = parameterMap.get("model")[0];

        CPU cpu = new CPU (vendorName, frequency, model);
        notebookService.createCPU(cpu);

        String pageAddress = "/hw7/addCPU.jsp";
        request.setAttribute("reg_result", "CPU was added");
        request.getRequestDispatcher(pageAddress).forward(request, resp);
    }
}