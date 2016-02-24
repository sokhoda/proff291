package hw7.notes.view;

import hw7.notes.dao.NotebookDao;
import hw7.notes.dao.NotebookDaoImpl;
import hw7.notes.dao.VendorDao;
import hw7.notes.domain.Notebook;
import hw7.notes.service.NotebookService;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by s_okhoda on 09.02.2016.
 */
@WebServlet(name = "HW7Menu", value = "/MainNote")
public class Menu extends HttpServlet {
    public static final String NameSurname = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";

    public static NotebookService service;
    private VendorDao vendorDao;

    @Override
    public void init() {
        service = new NotebookServiceImpl();
        vendorDao = (((NotebookServiceImpl)service).getVendorDao());
        ((NotebookServiceImpl)service).getLog().info("Menu.init()");
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        if (req.getParameter("crVen") != null) {
            try {
                req.setAttribute("mode", "0");
                req.getRequestDispatcher("/hw7.notes/pages/addVendor.jsp")
                        .forward(req, res);
                return;
            }
            catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        }
        if (req.getParameter("crCPU") != null) {
            try {
                req.getRequestDispatcher("/hw7.notes/pages/addCPU.jsp")
                        .forward(req, res);
                return;
            }
            catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        }


        if (req.getParameter("updVen") != null) {
            try {
                req.setAttribute("mode", "1");
                req.setAttribute("SelInx", "0");
                req.getRequestDispatcher("/hw7.notes/pages/addVendor.jsp")
                        .forward(req, res);
                return;
            }
            catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        }

        if (req.getParameter("updCPU") != null) {
            try {
                req.getRequestDispatcher("/hw7.notes/pages/updateCPU.jsp")
                        .forward(req, res);
                return;
            }
            catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        }


    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
//        try {
//
//            if (req.getParameter("back") != null) {
//                req.getRequestDispatcher("/hw6.notes/pages/menu.jsp").forward
//                        (req, res);
//                return;
//            }
//
//            if (req.getParameter("addNoteB") != null){
////                res.getWriter().print("Add notebook");
////                return;
//                String serial = req.getParameter("serial");
//                String vendor = req.getParameter("vendor");
//                String model = req.getParameter("model");
//                GregorianCalendar manDateGreg = String2Gregorian(req.getParameter("manDate"));
//                Integer priceInt = String2Integer(req.getParameter("price"));
//
//                Long id = service.add(new Notebook(serial, vendor, model,
//                        manDateGreg, priceInt));
//                if (id != null){
//                    setMessageAttr(req,"green", "Notebook '" + serial +
//                            "' was successfully added.");
//                }
//                else {
//                    setMessageAttr(req,"red", "Failed to add notebook " +
//                            "'" + serial + "'.");
//                }
//            }
//        }
//        catch (NumberFormatException | ParseException  | HibernateException e) {
//            setMessageAttr(req,"red", e.getMessage());
//        }
//        catch (Exception e) {
//            throw new ServletException(e.getMessage());
//        }
//        setNoteAttributes(req);
//        req.getRequestDispatcher("/hw6.notes/pages/addNotebook.jsp").forward(req, res);
    }

    private void setNoteAttributes(HttpServletRequest req){
        req.setAttribute("serialA", req.getParameter("serial"));
        req.setAttribute("vendorA", req.getParameter("vendor"));
        req.setAttribute("modelA", req.getParameter("model"));
        req.setAttribute("manDateA", req.getParameter("manDate"));
        req.setAttribute("priceA", req.getParameter("price"));
    }


}
