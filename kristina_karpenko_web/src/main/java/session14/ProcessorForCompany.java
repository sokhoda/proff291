package session14;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
import java.util.*;

@WebServlet("/formCompany")
public class ProcessorForCompany extends HttpServlet {


    private static Logger log = Logger.getLogger(Processor.class);
    SessionFactory factory;
    String name;

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
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        name = parameterMap.get("companyName")[0];
        String name = request.getParameter("companyName");

        response.getWriter().print(hiber(name));
        response.getWriter().print("Your name is " + name);

    }

    private String hiber(String name) {

        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        Query query;
        ArrayList error = new ArrayList<>(Arrays.asList("Error. List is empty"));
        try {
            session = factory.openSession();
            //query = session.createQuery("from Person p join p.company c on c.name = :name");
           // query = session.createQuery("from Person p join p.company c on c.name = :name");
            query = session.createQuery("from Company c ");
           // query.setParameter("name", name);
            //List<Object[]> list = query.list();

           // String res = list.toString();
            String res =query.list().toString();
//
//            List result = new ArrayList<>();
//            if(list == null){
//                return error;
//            }
//            if (result != null) {
//                for (Object pers : result) {
//                    list.add((Person) pers);
//                }
//            }
            return res;



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
        factory.close();
        return null;
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", "al1");
        request.getRequestDispatcher("index1.jsp").forward(request, response);

        response.getWriter().print("Hello servlet");
    }
}
