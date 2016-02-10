package hw6.notes.view;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
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

    SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg =
                new Configuration().configure("hw6.notes/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        try {
            if (req.getParameter("addNote") != null) {
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
            ServletException {
        try {
            if (req.getParameter("addNoteB") != null){
                String serial = req.getParameter("serial");
                String vendor = req.getParameter("vendor");
                String model = req.getParameter("model");
                String manDate = req.getParameter("manDate");
                String price = req.getParameter("price");
//                Notebook ntb = new Notebook(serial, vendor, model, manDate,
//                        price);
//                service.add(ntb);

            }


        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
