package session11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by Home on 06.02.2016.
 */
public class UserTaskMain {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(HiberConnect.class);



    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
            log.info("Connection established");

            User user1 = new User ("Igor", 25);
            User user2 = new User ("Bob", 15);
            User user3 = new User ("Tom", 33);
            session.beginTransaction();

            session.save (user1);
            session.save (user2);
            session.save (user3);

            session.getTransaction().commit();

            System.out.println("Enter id of User to delete: ");
            User user4 = new User("aa", 12);
            String answer = br.readLine();
            int userId = Integer.parseInt(answer);

            session.beginTransaction();
            user4.setId(userId);
            session.delete(user4);
            System.out.println("User was deleted");
            session.getTransaction().commit();



        } catch (HibernateException e) {
            log.error("Open session failed", e);
            //Rollback DB
            if (session != null) {
                session.getTransaction().rollback();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }
}


