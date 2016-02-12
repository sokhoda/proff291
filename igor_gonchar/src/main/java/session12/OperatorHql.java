package session12;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import session11.HiberConnect;
import session11.Region;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Home on 07.02.2016.
 */
public class OperatorHql {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().configure("session12/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);

        Session session = null;
        try {
            session = factory.openSession();
            int operatorId = 42;
            String login = "b1";

            Query query = session.createQuery("from Operator r where r.login= '" + login + "'");
            List<org.hibernate.cache.spi.Region> list = query.list();
            if (list.isEmpty()) {
                log.info("There is no such User in DB");
            } else {
                query = session.createQuery("from Operator r where r.login != '" + login + "'");
                List<org.hibernate.cache.spi.Region> list2 = query.list();
                log.info(list2);
            }

            System.out.println("-------------------------------");

            //Works only with objects. Doesn't need transaction (like select in SQL)
            // for like SQL - insert (save), update - we need transaction
            query = session.createQuery("from Operator r where r.id > " + operatorId);
            List<org.hibernate.cache.spi.Region> list3 = query.list();


            /*int count = 0;
            int listSize = list3.size();

            while(count < listSize){
                query.setFirstResult(count);
                query.setMaxResults(3);
                count +=2;

            }*/

            int portionSize = 2;
            List count;
            for (int i = 0; (count = query.list()).size() != 0 ; i++) {
                query.setFirstResult(i);
                query.setMaxResults(portionSize);
                System.out.println(count);
            }


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
