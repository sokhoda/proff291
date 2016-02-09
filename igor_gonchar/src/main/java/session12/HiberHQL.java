package session12;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.spi.Region;
import session11.HiberConnect;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 07.02.2016.
 */
public class HiberHQL {
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
            Query query = session.createQuery("from Region r where r.id > 2");
            List<Region> list = query.list();
            log.info(list);

            query = session.createQuery("select r.id, r.name from Region r where r.id > 2");
            List<Object[]> list2 = query.list();
            System.out.println(Arrays.toString(list2.get(0)));
            System.out.println(Arrays.toString(list2.get(1)));
            log.info(list2);

            query = session.createQuery("select count(*) from Region r");
            long count = (long) query.uniqueResult();
            System.out.println(count);

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            //Rollback DB
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
}
