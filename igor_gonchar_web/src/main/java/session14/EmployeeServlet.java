package session14;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session6.controller.FormProcessor;
import web.domain.Employee;

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
 * Created by Home on 14.02.2016.
 */
@WebServlet("/employeeForm")
public class EmployeeServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(EmployeeServlet.class);
    SessionFactory factory;

    public void init() throws ServletException {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("session14/hibernate.cfg.xml");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();

            factory = cfg.buildSessionFactory(standardServiceRegistry);
        } catch (Exception e) {
            log.error("Open session failed", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        boolean validation = hiber(login, password);
       if(validation){
           response.getWriter().print("Success");
       } else {
           response.getWriter().print("No such employee");
       }

    }

    private boolean hiber(String login, String password) {
        boolean result = false;
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Employee n where n.firstName= '" + login + "' AND n.lastName = '" + password + "'");
            List<Employee> list = query.list();
            if (list.size() == 1) {
                result = true;
            }


        } catch (HibernateException e) {
            log.error("Open session failed", e);
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
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "al1");
        request.getRequestDispatcher("index.jsp").forward(request, response);

        response.getWriter().print("Hello servlet");
    }
}

