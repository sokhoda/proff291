package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Сергей on 06.02.2016.
 */
public class HiberNotebooks {
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
            log.info("Connection established");

            session = factory.openSession();
//            for (int i=0; i<10; i++) {
//                Notebook nout = new Notebook();
//                nout.setName("HP"+i);
//                session.beginTransaction();
//                session.save(nout);
//                session.getTransaction().commit();
//            }

            Scanner scan = new Scanner(System.in);
            long note_num=scan.nextLong();

            session.beginTransaction();
            Notebook currNout = (Notebook) session.get(Notebook.class, note_num);
            session.delete(currNout);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session!=null) {
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
