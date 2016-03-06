package controller.session14.controller;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import web.domain.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 17.01.16
 */
@WebServlet("/form14")
public class FormProcessor extends HttpServlet {
    private static Logger log = Logger.getLogger(FormProcessor.class);
    SessionFactory factory;

    @Override
    public void init() throws ServletException {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();

            factory = cfg.buildSessionFactory(standardServiceRegistry);
        } catch (Exception e) {
            log.error("Open session failed", e);
        }
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("login");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        response.getWriter().print(hiber());
        //response.getWriter().print("Your name is " + login);

    }

    private Employee hiber() {

        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            return (Employee) session.get(Employee.class, 101L);
        } catch (HibernateException e) {
            log.error("Open session failed", e);

        } finally {
            if (session != null) {
                session.close();
            }
        }
//        log.info(session);
        factory.close();
        return null;
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "al1");
        request.getRequestDispatcher("index.jsp").forward(request, response);

        response.getWriter().print("Hello servlet");
    }
}
