package hw7.notes.view;

import hw7.notes.service.NotebookService;
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
@WebServlet("/add2Store")
public class AddNote2Store extends HttpServlet {
    public static final String NameSurname = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";
    private NotebookService service;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {

    }

    public SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg =
                new Configuration().configure("hw7.notes/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    private void setMessageAttr(HttpServletRequest req, String color, String
            message){
        req.setAttribute("messageColor", color);
        req.setAttribute("messageText", message );
    }


    public static String[] getAttribArray(HttpServletRequest req){
        String[] arr = new String[2];
        arr[0] = getAttribValue(req,"messageColor");
        arr[1] = getAttribValue(req, "messageText");
        return  arr;
    }

    public static String checkDate(GregorianCalendar gc) {
        SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
        return (gc == null ? "null": format1.format(gc.getTime()));
    }

    public static String getAttribValue(HttpServletRequest req, String name){
        if (name == null){
            return "";
        }
        return (req.getAttribute(name) == null ? "" : (String)req.getAttribute(name));
    }
}
