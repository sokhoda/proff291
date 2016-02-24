package hw7.notes.view;

import hw7.notes.service.NotebookService;
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
@WebServlet("/List")
public class NList extends HttpServlet {
    public static final String NameSurname = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";
    private NotebookService service;

//    @Override
//    public void init() {
//        SessionFactory sessionFactory = getSessionFactory();
//        NotebookDao noteDao = new NotebookDaoImpl(sessionFactory);
//        service = new NotebookServiceImpl(noteDao);
//
//    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
            if (req.getParameter("back") != null) {
                try {
                    req.setAttribute("messageText", "");
                    String cntMark = req.getParameter("cntMark");
                    int cnt = Integer.parseInt(cntMark.split(" of ")[0]);
                    int totPages = Integer.parseInt(cntMark.split(" of ")[1]);
                    req.setAttribute("totPages", totPages);

                    if (cnt > 1) {
                        cnt--;
                    }
                    req.setAttribute("cnt", cnt);

                    req.getRequestDispatcher("/hw7.notes/pages/noteList.jsp")
                            .forward(req, res);
                    return;
                }
                catch (Exception e) {
                    throw new ServletException(e.getMessage());
                }
            }
            if (req.getParameter("forward") != null) {
                try {
                    req.setAttribute("messageText", "");
                    String cntMark = req.getParameter("cntMark");
                    int cnt = Integer.parseInt(cntMark.split(" of ")[0]);
                    int totPages = Integer.parseInt(cntMark.split(" of ")[1]);
                    req.setAttribute("totPages", totPages);

                    if (cnt < totPages) {
                         cnt++;
                    }
                    req.setAttribute("cnt", cnt);

                    req.getRequestDispatcher("/hw7.notes/pages/noteList.jsp")
                            .forward(req, res);
                    return;
                }
                catch (Exception e) {
                    throw new ServletException(e.getMessage());
                }
            }
//            if (req.getParameter("delNote") != null){
//                try {
//                    Long id = String2Long(req.getParameter("idDelNote"));
//                    if (service.delete(id)){
//                        setMessageAttr(req, "green", "Notebook successfully " +
//                                "deleted.");
//                    }
//                    else {
//                        setMessageAttr(req, "red", "Failed to delete notebook" +
//                                ".");
//                    }
//                    req.getRequestDispatcher("/hw6.notes/pages/menu.jsp").forward
//                            (req, res);
//                    return;
//                }
//                catch (Exception e){
//                    throw new ServletException(e.getMessage());
//                }
//            }
//            if (req.getParameter("updtPrice") != null){
//                try {
//                    Long id = String2Long(req.getParameter("idUpdtPrice"));
//                    Double price = String2Double(req.getParameter("priceUpdtPrice"));
//
//                    if (service.changePrice(id, price)){
//                        setMessageAttr(req,"green", "Price successfully " +
//                                "updated.");
//                    }
//                    else {
//                        setMessageAttr(req,"red", "Failed to update price " +
//                                "value.");
//                    }
//                    req.getRequestDispatcher("/hw6.notes/pages/menu.jsp").forward
//                            (req, res);
//                    return;
//                }
//                catch (Exception e){
//                    throw new ServletException(e.getMessage());
//                }
//            }
//            if (req.getParameter("updtSnVendor") != null){
//                try {
//                    Long id = String2Long(req.getParameter("idUpdtSnVendor"));
//                    String serial = req.getParameter("serialUpdtSnVendor");
//                    String vendor = req.getParameter("vendorUpdtSnVendor");
//
//                    if (service.changeSerialVendor(id, serial, vendor)){
//                        setMessageAttr(req,"green", "Serial, vendor " +
//                                "successfully updated.");
//                    }
//                    else {
//                        setMessageAttr(req,"red", "Failed to update serial, " +
//                                "vendor value.");
//                    }
//                    req.getRequestDispatcher("/hw6.notes/pages/menu.jsp").forward
//                            (req, res);
//                    return;
//                }
//                catch (Exception e){
//                    throw new ServletException(e.getMessage());
//                }
//            }
//            if (req.getParameter("delNoteByModel") != null){
//                try{
//                    String model = req.getParameter("modelDelNoteByModel");
//
//                    if (service.deleteByModel(model)){
//                        setMessageAttr(req,"green", "Notebooks with model='" +
//                                model + "' successfully deleted");
//                    }
//                    else {
//                        setMessageAttr(req,"red", "Failed to delete notebooks" +
//                                " with model='" + model + "'");
//                    }
//                    req.getRequestDispatcher("/hw6.notes/pages/menu.jsp").forward
//                            (req, res);
//                    return;
//                }
//                catch (Exception e){
//                    throw new ServletException(e.getMessage());
//                }
//            }
//            if (req.getParameter("listNoteByVendor") != null){
//                try {
//                    String vendor = req.getParameter("vendorListNoteByVendor");
//                    List<Notebook> nlist = service.findByVendor(vendor);
//                    req.setAttribute("nlist", nlist);
//                    req.getRequestDispatcher("/hw6.notes/pages/noteList.jsp").forward
//                            (req, res);
//                    return;
//                }
//                catch (Exception e){
//                    throw new ServletException(e.getMessage());
//                }
//            }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {

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
