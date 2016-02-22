package session14;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Сергей on 14.02.2016.
 */
@WebServlet("/hiber")
public class Task3 extends HttpServlet {
    private static Logger log = Logger.getLogger(HiberProcessor.class);
    SessionFactory factory = getSessionFactory();
    Session session = null;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");


        try {
            session = factory.openSession();
            session.beginTransaction();
            String name = "NAME";
            Query getUsers = session.createQuery(" from Employee e, Company c where e.company_id = c.id and c.name=:name");
            getUsers.setParameter("name", name);
            List users = getUsers.list();

            for (int i = 0; i < users.size(); i++) {
                users.get(i).toString();
            }

        } catch (HibernateException e) {
            if (session!=null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }


    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("doGetForm");
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry);
    }

}