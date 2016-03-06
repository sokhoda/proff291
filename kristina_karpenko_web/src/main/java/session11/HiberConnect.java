package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.Date;
import java.util.Locale;


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
            session = factory.openSession();
            //Region region = (Region) session.get(Region.class, 1L);
            //log.info(region);

            Users users = new Users("kRIS","vilum2015");
            users.setDateRegistration(new Date());

            session.beginTransaction();
            session.save(users);
            session.getTransaction().commit();

//            Region uae = new Region("EuroUkraine");
//            session.beginTransaction();
//            session.save(uae);
//            uae.setName("AsiaUkraine");
//            session.getTransaction().commit();
//
//            uae.setName("AsiaUkraine");
//            session.update(uae);
//           session.delete("EuroUkraine",uae);
//            session.getTransaction().commit();

            log.info("Connection established");
            log.info(session);
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

