package session11;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by s_okhoda on 06.02.2016.
 */
public class HiberTask1 {

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
            log.info("Connection established");
//            log.info(session);

//            session.beginTransaction();

//            User user1 = new User("Pavel","1");// session.get(Region.class, 2L);
//            log.info(user1.getLogin() + " added, id=" + session.save(user1));
//
//            User user2 = new User("Oksana","2");
//            log.info(user2.getLogin() + " added, id=" + session.save(user2));
//
//            User user3 = new User("Kostya","3");
//            log.info(user3.getLogin() + " added, id=" + session.save(user3));
//            session.getTransaction().commit();

//            log.info(region);
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ид пользователя:");
            int id = -1;
            boolean flag = true;
            User myUser = null;

            while(myUser == null) {
                while (flag) {
                    try {
                        id = Integer.parseInt(scan.nextLine());
                        flag = false;
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Некорректный ид. Попробуйте еще " +
                                "раз(-1 для выхода):");
                    }
                }
                if (id == -1) {
                    return;
                }
                myUser = (User) session.get(User.class, id);
                if (myUser == null) {
                    System.out.println("Пользователь с ид=" + id + " не " +
                            "найден. Попробуйте еще раз(-1 для выхода):");
                    flag = true;
                }
            }
            session.beginTransaction();
            session.delete(myUser);
            session.getTransaction().commit();

            System.out.println("Пользователь с ид=" + id + " удален.");

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null){
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
