package session13.domain2;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session12.HiberQueries;

import java.util.List;
import java.util.Locale;

/**
 * Created by Юлия on 13.02.2016.
 */
public class Main {

//    private static Logger log = Logger.getLogger(HiberQueries.class);
//
//    public static void main(String[] args) {
//
//        SessionFactory factory = getSessionFactory();
//        log.info("Reference to SessionFactory " + factory);
//
//        Session session = null;
//        try {
//            session = factory.openSession();
//            // Set<Company> company = new HashSet<>();
//            Company lucoil = new Company(20000, "Lucoil");
//            Company motor = new Company(20000, "motor");
//            Persons id1 = new Persons(lucoil);
//            Persons id2 = new Persons(motor);
//            lucoil.add(id1);
//            motor.add(id2);
//
//            Query query = session.createQuery("from Company1");
//            List<Company> list = query.list();
//
//            session.beginTransaction();
//
//            session.save(lucoil);
//            session.save(motor);
//            session.save(id1);
//            session.save(id2);
//            session.getTransaction().commit();
//
//            log.info(list);
//
//
//        } catch (HibernateException e) {
//            log.error("Open session failed", e);
//            if (session != null) {
//                session.getTransaction().rollback();
//            }
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//            factory.close();
//        }
//        log.info(session);
//
//    }
//
//    private static SessionFactory getSessionFactory() {
//        Locale.setDefault(Locale.ENGLISH);
//        Configuration cfg = new Configuration().configure("session13/hibernate.cfg.xml");
//        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
//        sb.applySettings(cfg.getProperties());
//        StandardServiceRegistry standardServiceRegistry = sb.build();
//
//        return cfg.buildSessionFactory(standardServiceRegistry);
//    }
//
//    private static long showALLPersons(long id) {
//        SessionFactory factory = getSessionFactory();
//        log.info("Reference to SessionFactory " + factory);
//
//        Session session = null;
//        session = factory.openSession();
//
//        Query query = session.createQuery("from Company1 where id ="+id);
//        List<Company> list = query.list();
//
//        session.beginTransaction();
//
//        session.getTransaction().commit();
//
//        log.info(list);
//
//
//        return id;
//    }
}
