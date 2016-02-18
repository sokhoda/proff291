package hw7.view;

import hw7.dao.*;
import hw7.domain.Vendor;
import hw7.service.NotebookService;
import hw7.service.NotebookServiceImpl;
import hw7.util.HiberSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@WebServlet("/addVendor")
public class AddVendor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String vendorName = request.getParameter("vendorName");
        Vendor vendor = new Vendor(vendorName);
        Main.notebookService.createVendor(vendor);

    }
}
