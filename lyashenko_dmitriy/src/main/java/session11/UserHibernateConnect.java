package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Solyk on 06.02.2016.
 */
public class UserHibernateConnect {


    private static Logger log = Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/UserHibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {

            session = factory.openSession();

            UserHibernate userHibernate1 = new UserHibernate("YUIO", "908");
            UserHibernate userHibernate2 = new UserHibernate("RRTET", "o904908");
            UserHibernate userHibernate3 = new UserHibernate("VVBXFS", "908opodjhd");


//            session.beginTransaction();
//            session.save(userHibernate1);
//            session.getTransaction().commit();
//            session.beginTransaction();
//            session.save(userHibernate2);
//            session.getTransaction().commit();
            session.beginTransaction();
            session.save(userHibernate3);
            session.getTransaction().commit();


            log.info("Connection established");
            log.info(session);

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if(session != null){
                session.getTransaction().rollback();
            }
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
