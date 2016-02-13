package session11;

import org.hibernate.HibernateException;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.Locale;

/**
 * Created by Юлия on 06.02.2016.
 */
public class CreateNewUsers {

    private static Logger log = Logger.getLogger(HibernateConnection.class);

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
            session = factory.openSession();

            User yul = new User("YULIIA");
            yul.setLogin("yul123");
            yul.setPassword("1234");
            yul.setDate(new Date());

            User den = new User("DENIS");
            den.setLogin("deniel");
            den.setPassword("4232");
            den.setDate(new Date());

            User al = new User("AllA");
            al.setLogin("al23");
            al.setPassword("9876");
            al.setDate(new Date());

            session.beginTransaction();
            session.save(yul);
            session.save(den);
            session.save(al);

            session.getTransaction().commit();
//

//            log.info(region);
            log.info("Connection established");
            log.info(session);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
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
