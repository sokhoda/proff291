package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.09.14
 */
public class HiberConnect {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            Region ua = new Region("EuroUkraina");
            session = factory.openSession();
            log.info("Connection established");
            // System.out.println("Connection established");
            //   log.info(session);
            //   session.beginTransaction();
            //   session.save(ua);
            //    session.getTransaction().commit();

            //   ua.setName("AsiaUkraina");
            //   session.beginTransaction();
            //    session.update(ua);
            //    session.getTransaction().commit();
            //   session.beginTransaction();
            //   Region ua1=(Region)session.get(Region.class,new Long(55));
            //   System.out.println(ua1);
            //   Actor actor = (Actor)session.get(Actor.class,new Long(1));
            //   session.getTransaction().commit();
            //  session.beginTransaction();
            //  session.delete(ua);
            //  session.getTransaction().commit();
            Query q = session.createQuery("select count(*) from session11.Region r");
            List r = (List) q.list();


        } catch (HibernateException e) {
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}

