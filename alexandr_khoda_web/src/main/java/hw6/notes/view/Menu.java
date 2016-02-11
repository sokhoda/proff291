package hw6.notes.view;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by s_okhoda on 09.02.2016.
 */
@WebServlet("/MenuNote")
public class Menu extends HttpServlet {
    public static final String NameSurname = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";
    private NotebookService service;

    @Override
    public void init() {
        SessionFactory sessionFactory = getSessionFactory();
        NotebookDao noteDao = new NotebookDaoImpl(sessionFactory);
        service = new NotebookServiceImpl(noteDao);

    }

    public SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg =
                new Configuration().configure("hw6.notes/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    public GregorianCalendar String2Gregorian(String dateStr) throws ParseException {
        if (dateStr == null || dateStr.length() == 0){
            return  null;
        }
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        date = df.parse(dateStr);
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return (GregorianCalendar) cal;
    }
    public Integer String2Integer(String str) throws NumberFormatException{
        if (str == null) {
            return null;
        }
        if (str.length() == 0){
            return 0;
        }
        return Integer.parseInt(str);
    }

    private void setNoteAttributes(HttpServletRequest req){
        req.setAttribute("serialA", req.getParameter("serial"));
        req.setAttribute("vendorA", req.getParameter("vendor"));
        req.setAttribute("modelA", req.getParameter("model"));
        req.setAttribute("manDateA", req.getParameter("manDate"));
        req.setAttribute("priceA", req.getParameter("price"));
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        try {
            if (req.getParameter("addNote") != null) {
                req.setAttribute("messageText","");
                req.getRequestDispatcher("/hw6.notes/pages/addNotebook.jsp")
                        .forward(req, res);
            }

        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {
        try {

            if (req.getParameter("back") != null) {
                req.getRequestDispatcher("/hw6.notes/pages/menu.jsp").forward
                        (req, res);
            }

            if (req.getParameter("addNoteB") != null){
//                res.getWriter().print("Add notebook");
//                return;
                String serial = req.getParameter("serial");
                String vendor = req.getParameter("vendor");
                String model = req.getParameter("model");
                GregorianCalendar manDateGreg = String2Gregorian(req.getParameter("manDate"));
                Integer priceInt = String2Integer(req.getParameter("price"));

                Long id = service.add(new Notebook(serial, vendor, model,
                        manDateGreg, priceInt));
                if (id != null){
                    req.setAttribute("messageColor","green");
                    req.setAttribute("messageText", "Notebook '" + serial +
                            "' was successfully added." );
                }
                else {
                    req.setAttribute("messageColor","red");
                    req.setAttribute("messageText", "Failed to add notebook " +
                            "'" + serial + "'." );
                }

            }
        }
        catch (NumberFormatException | ParseException  | HibernateException e) {
            req.setAttribute("messageColor","red");
            req.setAttribute("messageText", e.getMessage());
        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        setNoteAttributes(req);
        req.getRequestDispatcher("/hw6.notes/pages/addNotebook.jsp").forward(req, res);
    }
}
