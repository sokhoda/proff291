package web.domain;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
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
 * Created by Юлия on 14.02.2016.
 */

@WebServlet("/form1")
public class EmployeeImpl extends HttpServlet {
    private static Logger log = Logger.getLogger(EmployeeImpl.class);
    SessionFactory factory;
    EmployeeDao employeeDao;
    Employee employee;

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
        Employee employee = new Employee();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("firstName")[0];
        String password = parameterMap.get("lastName")[0];

//       if(employee.isExist(login,password)){
//            response.getWriter().print("Hello");
//        }
//        else{
//           response.getWriter().print("Bye");
//        }
        response.getWriter().print(hiber());
        //  response.getWriter().print("Hello");

    }

    private Employee hiber() {

        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
//          List<Object[]> list=session.createQuery("from Employee e join e.department d where e.salary");
            return (Employee) session.get(Employee.class, 100L);
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
        return null;
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "al1");
     //   request.getRequestDispatcher("index1.jsp").forward(request, response);

        response.getWriter().print("Hello");
    }
}
