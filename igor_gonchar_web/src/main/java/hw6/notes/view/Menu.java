package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.h2.mvstore.type.StringDataType;
import org.hibernate.*;
import session6HomeTask.RegisterBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        String message = "Operation was done successfully";

        Map<String, String[]> parameterMap = request.getParameterMap();
        HibernateUtil util = new HibernateUtil();
        Logger log = HibernateUtil.getLog();
        SessionFactory factory = util.getSessionFactory();
        Session session = null;

        switch (hiddenParam) {
            case "row1":
                try {
                    session = factory.openSession();

                    String serialS = parameterMap.get("serial")[0];
                    long serial = Long.parseLong(serialS);
                    String vendor = parameterMap.get("vendor")[0];
                    String model = parameterMap.get("model")[0];
                    String manufDate = parameterMap.get("manufactureDate")[0];
                    String priceS = parameterMap.get("price")[0];
                    int price = Integer.parseInt(priceS);
                    String dateS = parameterMap.get("manufactureDate")[0];

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        Date date = sdf.parse(dateS);
                        session.beginTransaction();
                        Notebook note = new Notebook(serial, vendor, model, date, price);

                        // long id = (long)
                        session.save(note);
                        session.getTransaction().commit();
                    } catch (Exception e){
                        System.out.println("This fucking date problem!");
                    }


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

                try {
                    String idS = parameterMap.get("id")[0];
                    int id = Integer.parseInt(idS);

                    session = factory.openSession();

                    Query query = session.createQuery("from Notebook n where n.id= " + id);
                    List<Notebook> list = query.list();
                    log.info(list);

                    if (list.size() == 1) {

                        session.beginTransaction();
                        session.createSQLQuery("delete from NOTES where id =:id").setLong("id", id).executeUpdate();
                        session.getTransaction().commit();
                    }

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
            case "row3":
                try {
                    String idS = parameterMap.get("id")[0];
                    int id = Integer.parseInt(idS);

                    String priceS = parameterMap.get("price")[0];
                    int price = Integer.parseInt(priceS);

                    session = factory.openSession();

                    Query query = session.createQuery("from Notebook n where n.id= " + id);
                    List<Notebook> list = query.list();
                    log.info(list);

                    if (list.size() == 1) {
                       /* Notebook note = new Notebook();
                        session.beginTransaction();
                        note.setPrice(price);
                        session.update(note);
                        session.getTransaction().commit();*/

                        session.beginTransaction();
                        session.createSQLQuery("update NOTES set price =" + price + " where id =:id").setLong("id", id).executeUpdate();
                        session.getTransaction().commit();

                    }

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
            case "row4":

                try {
                    String idS = parameterMap.get("id")[0];
                    int id = Integer.parseInt(idS);
                    String priceS = parameterMap.get("price")[0];
                    int price = Integer.parseInt(priceS);
                    String serialS = parameterMap.get("serial")[0];
                    int serial = Integer.parseInt(serialS);

                    session = factory.openSession();

                    Query query = session.createQuery("from Notebook n where n.id= " + id);
                    List<Notebook> list = query.list();
                    log.info(list);

                    if (list.size() == 1) {
                        session.beginTransaction();
                        session.createSQLQuery("update NOTES set price =" + price + ", serial =" + serial + " where id =:id").setLong("id", id).executeUpdate();
                        session.getTransaction().commit();
                    }


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
            case "row5":
                try {
                    session = factory.openSession();
                    String model = parameterMap.get("model")[0];

                    session.beginTransaction();
                    session.createSQLQuery("delete from NOTES where model =:model").setString("model", model).executeUpdate();
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
            case "row6":
              break;
            case "row7":
                /*try {
                    session = factory.openSession();

                    String priceS = parameterMap.get("price")[0];
                    int price = Integer.parseInt(priceS);
                    String dateS = parameterMap.get("year")[0];
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date date = sdf.parse(dateS);


                    Query query = session.createQuery("SELECT n.id, n.serial, n.vendor, n.price FROM Notebook n WHERE n.price =:price AND n.manufactureDate ='" + date +"'");
                    query.setParameter("price", price);
                    // query.setParameter("date", MANUFACTURE_DATE);
                    StringBuilder sb = new StringBuilder();
                    sb.append("ID:, Serial, Vendor, Price");
                    sb.append("<br/>");
                    List<Object[]> list2 = query.list();
                    for (int i = 0; i < list2.size(); i++) {
                        sb.append(Arrays.toString(list2.get(i)));
                        sb.append("<br/>");
                    }
                    message = sb.toString();


                } catch (HibernateException e) {
                    log.error("Open session failed", e);
                    //Rollback DB
                    if (session != null) {
                        session.getTransaction().rollback();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                } finally {
                    util.closeSessionAndFactory(factory, session);
                }
*/
                break;
            case "row8":
                List<Notebook> list = new ArrayList<Notebook>();
                try {
                  /*  session = factory.openSession();
                    ScrollableResults noteCursor = session.createQuery("FROM Notebook").scroll();
                    int count = 0;

                    while (noteCursor.next()) {
                        Notebook note = (Notebook) noteCursor.get(0);
                        list.add(note);
                        if (++count % 20 == 0) {
                            session.flush();
                            session.clear();
                        }
                    }
                    message = list.toString();
*/
                    session = factory.openSession();
                    Query query = session.createQuery("select n.id, n.serial, n.vendor, n.price from Notebook n");
                    StringBuilder sb = new StringBuilder();
                    sb.append("ID:, Serial, Vendor, Price");
                    sb.append("<br/>");
                    List<Object[]> list2 = query.list();
                    for (int i = 0; i < list2.size(); i++) {
                        sb.append(Arrays.toString(list2.get(i)));
                        sb.append("<br/>");
                    }
                    message = sb.toString();

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
            default:
                response.getWriter().println("ANOTHER ROW");
                break;
        }

        String pageAddress = "/notebooksPage.jsp";
        request.setAttribute("reg_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, response);

    }
}
