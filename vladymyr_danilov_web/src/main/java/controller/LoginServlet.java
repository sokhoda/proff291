package controller;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
//            log.error("Open session failed", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        String message = null;
        String address = "/login.jsp";

        if ( login.isEmpty() || password.isEmpty() ) {
            message = "Not all fields are filled!";
        } else if ( !RegisterUser.isContainUser(login) ) {
            message = "This login is not registered";
            address = "/registration.jsp";
        } else if ( !RegisterUser.getUsers().get("password")[0].equals(password) ) {
            message = "Wrong password!";
        } else {
            address = "/index1.jsp";
        }

        response.getWriter().print(hiber());

        request.setAttribute("message", message);
        request.getRequestDispatcher(address).forward(request, response);

    }

    private Employee hiber() {

//        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            session.createQuery("from Employer c join ");
            return (Employee) session.get(Employee.class, 100L);
        } catch (HibernateException e) {
//            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
//        log.info(session);
        factory.close();
        return null;
    }
}
