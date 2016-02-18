package hw7.notes.view;

import hw7.notes.dao.VendorDao;
import hw7.notes.dao.VendorDaoImpl;
import hw7.notes.domain.Vendor;
import hw7.notes.exception.InvalidParamValueException;
import hw7.notes.service.NotebookService;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session14.service.GeneralServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hw7.notes.view.Servlet.checkStringPar;
import static hw7.notes.view.Servlet.setMessageAttr;

/**
 * Created by s_okhoda on 09.02.2016.
 */
@WebServlet("/AddVen")
public class AddVendor extends HttpServlet {
    public static final String NameSurname = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";
    private NotebookService service;
    private VendorDao vendorDao;

    @Override
    public void init() {
        service = new NotebookServiceImpl();
        vendorDao = (((NotebookServiceImpl)service).getVendorDao());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {

        if (req.getParameter("back") != null) {
            req.getRequestDispatcher("/hw7.notes/pages/menu.jsp").forward(req, res);
            return;
        }

        if (req.getParameter("add") != null) {
            try {
                String name = req.getParameter("name");
                 if (!checkStringPar(req,"name")){
                     if(vendorDao.checkExist(new Vendor(name))){
                         setMessageAttr(req, "red", "Vendor '" +
                                 name + "' already exists in DB.");
                     }
                     else {
                         if (vendorDao.create(new Vendor(name)) != null) {
                             setMessageAttr(req, "green", "Vendor successfully added.");
                         }
                         else {
                             setMessageAttr(req, "red", "Failed to add Vendor '" +
                                     name + "'.");
                         }
                     }
                     setVendorAttributes(req);
                }
                req.setAttribute("mode","0");
                req.getRequestDispatcher("/hw7.notes/pages/addVendor.jsp")
                        .forward(req, res);
                return;
            }
            catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        }

    }

    private void setVendorAttributes(HttpServletRequest req){
        req.setAttribute("nameA", req.getParameter("name"));
    }
}
