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
@WebServlet("/editVendor")
public class EditVendor extends HttpServlet {
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
        String name = parameterMap.get("name")[0];

        Long vendorId = Long.valueOf(parameterMap.get("vendorId")[0]);
        Vendor vendor = notebookService.getVendorById(vendorId);
        System.out.println(vendor);

        notebookService.updateVendor(vendor);

        String pageAddress = "/hw7/editVendor.jsp";
        request.setAttribute("reg_result", "Vendor was edited");
        request.getRequestDispatcher(pageAddress).forward(request, resp);

    }
}