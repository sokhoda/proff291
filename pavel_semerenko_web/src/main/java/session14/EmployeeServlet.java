package session14;

import org.hibernate.Session;
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
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Pavel on 14.02.2016.
 */
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet{
    SessionFactory sessionFactory;
    @Override
    public void init() throws ServletException {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hibernate/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> attributes = req.getParameterMap();
        Session session = sessionFactory.openSession();
        List<Object[]> list = session.createQuery("FROM Person e join e.company.companyName = '" +
                attributes.get("first_name") +
                "'").list();
        session.close();
        resp.getWriter().write(String.valueOf(list.toArray()));
    }
}
