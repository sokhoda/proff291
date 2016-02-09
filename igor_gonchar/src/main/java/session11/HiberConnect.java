package session11;


import com.sun.org.apache.regexp.internal.RE;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Locale;

/**
 * Created by Home on 06.02.2016.
 */
public class HiberConnect {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            Region region = (Region) session.get(Region.class, 1L);
            log.info(region);


            Region ua = new Region("EuroUkraine");
            session.beginTransaction();
           // session.save(ua);


           // ua.setName("AsiaUkraineA");
           // session.update(ua);
            ua.setId(10L); // Удалит из БД запись с ИД 10, а не типо новосозданный О
             session.delete(ua);
            session.getTransaction().commit();

            log.info("Connection established");
           // log.info(session);
        } catch (HibernateException e) {
            log.error("Open session failed", e);
            //Rollback DB
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
}