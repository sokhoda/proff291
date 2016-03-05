package session14;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Home on 14.02.2016.
 */
@WebServlet("/companyForm")
public class CompanyServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(CompanyServlet.class);
    SessionFactory factory;

    public void init() throws ServletException {
        try {
            Locale.setDefault(Locale.ENGLISH);
            Configuration cfg = new Configuration().configure("session14/hibernate1.cfg.xml");
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
        String companyName = parameterMap.get("login")[0];
        String res = hiber(companyName);

    }

    private String hiber(String companyName) {
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        String res = "Failed";
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Employee e join Company c ON e.company = c.employees WHERE c.name = '" + companyName + "'" );
            List<Employee> list = query.list();
            res = list.toString();

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
        return res;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "al1");
        request.getRequestDispatcher("index1.jsp").forward(request, response);

        response.getWriter().print("Hello servlet");
    }
}

