package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session6HomeTask.RegisterBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by i.gonchar on 2/10/2016.
 */
@WebServlet("/notebooksForm")
public class Menu extends HttpServlet

{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hiddenParam = request.getParameter("pageName");

        Map<String, String[]> parameterMap = request.getParameterMap();

        switch (hiddenParam) {
            case "row1":

                /*java.util.Date date = new java.util.Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String updatedDate = sdf.format(date);
*/
                HibernateUtil util = new HibernateUtil();
                Logger log = HibernateUtil.getLog();
                SessionFactory factory = util.getSessionFactory();
                Session session = null;
                try {
                    session = factory.openSession();
                    //log.info(session);

                    String serialS = parameterMap.get("serial")[0];
                    long serial = Long.parseLong(serialS);
                    String vendor = parameterMap.get("vendor")[0];
                    String model = parameterMap.get("model")[0];
                    String manufDate = parameterMap.get("manufactureDate")[0];
                    String priceS = parameterMap.get("price")[0];
                    int price = Integer.parseInt(priceS);

                    session.beginTransaction();
                    //  Notebook note = new Notebook(11111L, "Sony", "AAA", 110);
                    Notebook note = new Notebook(serial, vendor, model, price);

                    // long id = (long)
                    session.save(note);
                    session.getTransaction().commit();

                } catch (HibernateException e) {
                    log.error("Open session failed", e);
                    //Rollback DB
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                } finally {
                    util.closeSessionAndFactory(factory, session);
                }
                break;

            case "row2":
                HibernateUtil util2 = new HibernateUtil();
                Logger log2 = HibernateUtil.getLog();
                SessionFactory factory2 = util2.getSessionFactory();
                Session session2 = null;
                try {
                    String idS = parameterMap.get("id")[0];
                    int id = Integer.parseInt(idS);

                    session2 = factory2.openSession();

                    Query query = session2.createQuery("from Notebook n where n.id= " + id);
                    List<Notebook> list = query.list();
                    log2.info(list);
                    System.out.println(list.size());


                    if (list.size() == 1) {

                        session2.beginTransaction();
                        session2.createSQLQuery("delete from NOTES where id =:id").setLong("id", id).executeUpdate();
                        session2.getTransaction().commit();
                    }

                } catch (HibernateException e) {
                    log2.error("Open session failed", e);
                    //Rollback DB
                    if (session2 != null) {
                        session2.getTransaction().rollback();
                    }
                } finally {
                    util2.closeSessionAndFactory(factory2, session2);
                }
                break;
            case "row3":
                response.getWriter().println("ROW 3");
                break;
            case "row4":
                response.getWriter().println("ROW 4");
                break;
            case "row5":
                response.getWriter().println("ROW 5");
                break;
            case "row6":
                response.getWriter().println("ROW 6");
                break;
            case "row7":
                response.getWriter().println("ROW 7");
                break;
            default:
                response.getWriter().println("ANOTHER ROW");
                break;
        }

    }

}
