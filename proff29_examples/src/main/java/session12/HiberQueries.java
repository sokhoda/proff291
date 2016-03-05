package session12;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.Region;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 01.11.15
 */
public class HiberQueries {
    private static Logger log = Logger.getLogger(HiberQueries.class);

    public static void main(String[] args) {
        SessionFactory factory = getSessionFactory();
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("from Region r where r.id != 2");
            List<Region> list = query.list();
            log.info(list);

            query = session.createQuery("select r.id, r.name from Region r where r.id > 2");
            List<Object[]> list2 = query.list();
            System.out.println(Arrays.toString(list2.get(0)));
            System.out.println(Arrays.toString(list2.get(1)));
            log.info(list);

            String name = "%";
            query = session.createQuery("from Region r where r.name like :name");
            query.setParameter("name", name);

            int portionSize = 2;
            List list1;
            for (int i = 0; (list1 = query.list()).size() != 0; i += portionSize) {
                query.setFirstResult(i);
                query.setMaxResults(portionSize);
                System.out.println(list1);
            }

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
        log.info(session);

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
