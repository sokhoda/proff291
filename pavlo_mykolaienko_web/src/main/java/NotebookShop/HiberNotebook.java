package NotebookShop;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Created by Павло on 10.02.2016.
 */
public class HiberNotebook implements IntNotebookDao {
    private static Logger log = Logger.getLogger(HiberNotebook.class);
    public Configuration cfg;
    public StandardServiceRegistryBuilder sb;
    public StandardServiceRegistry standardServiceRegistry;
    public SessionFactory factory;
    public Session session = null;
    notebookslist nl = new notebookslist();
    Double hnprise = new Double(0);

    HiberNotebook() {
        Locale.setDefault(Locale.ENGLISH);
        cfg = new Configuration().configure("NotebookShop/hibernate.cfg.xml");
        sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        standardServiceRegistry = sb.build();

        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("NotebookShop/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    public static void main(String[] args) {
        //  HiberNotebook hn=new HiberNotebook();
        // if( hn.AddNotebook()){
        //    System.out.println("Ноутбук добавлено в базу");
        // }

    }

    public boolean AddNotebook() {

        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);
            session.beginTransaction();
            session.save(nl);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }

    public List ShowList() {

        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);
            List<notebookslist> r = (List<notebookslist>) session.createQuery("from NotebookShop.notebookslist").list();

            System.out.println(r);
            return r;
        } catch (HibernateException e) {
            log.error("Open session failed", e);

        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }

        return null;
    }

    public boolean DeleteNotebook() {
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);
            session.beginTransaction();
            session.delete(nl);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }

    public boolean UpdatePrice() {
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);
            double price = nl.getPrice();
            // Query q=session.createQuery("SELECT ns.id FROM NotebookShop.notebookslist ns WHERE ns.id="+nl.getId());
            nl = (notebookslist) session.get(notebookslist.class, new Long(nl.getId()));
            nl.setPrice(price);
            session.beginTransaction();
            session.update(nl);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }

    public boolean UpdateSerialVendor() {
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);
            String serial = nl.getSerial();
            String vendor = nl.getVendor();
            nl = (notebookslist) session.get(notebookslist.class, new Long(nl.getId()));
            nl.setSerial(serial);
            nl.setVendor(vendor);
            session.beginTransaction();
            session.update(nl);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }

    public boolean DeleteNotebookByName() {
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);

            List<notebookslist> r = session.createCriteria(notebookslist.class)
                    .add(Expression.like("model", nl.getModel())).list();
            System.out.println(r);
            Iterator iterator = r.iterator();
            while (iterator.hasNext()) {
                notebookslist nli = (notebookslist) iterator.next();
                session.beginTransaction();
                session.delete(nli);
                session.getTransaction().commit();
            }


            return true;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }

    }

    public List<notebookslist> ShowListByVendor() {
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            log.info(session);

            List<notebookslist> r = session.createCriteria(notebookslist.class)
                    .add(Expression.like("vendor", nl.getVendor())).list();
            System.out.println(r);


            return r;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }

    public List<notebookslist> ShowListByPrice() {
        List<notebookslist> r = new ArrayList<notebookslist>();
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");

            log.info(session);
            System.out.println(nl.getPrice());
            r = session.createCriteria(notebookslist.class)
                    .add(Expression.like("price", nl.getPrice())).list();

            //   Query query = session.createQuery("from NotebookShop.notebookslist where 'price' > :paramprice");
            //   query.setParameter("paramprice", nl.getPrice());
            //   List r = query.list();

            System.out.println(r);

            return r;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return r;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }

    public List<notebookslist> ShowListByDatePrice() {
        List<notebookslist> r = new ArrayList<notebookslist>();
        try {
            session = factory.openSession();
            log.info("Connection established");
            System.out.println("Connection established");
            System.out.println(nl.getPrice() + "  " + hnprise + "  " + nl.getManufacture_date());
            log.info(session);

            // Integer d1 = nl.getManufacture_date().to;
            r = session.createCriteria(notebookslist.class)
                    //        .add( Expression. between("manufacture_date", nl.getManufacture_date()) )
                    .add(Expression.between("price", nl.getPrice(), hnprise))
                    .list();

            //  Query query = session.createQuery("from NotebookShop.notebookslist where 'price' > :paramprice");
            //  query.setParameter("paramprice", nl.getPrice());
            //  List r = query.list();
            System.out.println(r);
            /////////////////////////////////


            return r;
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            return r;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
            System.out.println("Session close");
        }


    }
}
