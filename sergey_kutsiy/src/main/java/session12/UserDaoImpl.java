package session12;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.SourceType;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.HiberConnect;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Сергей on 07.02.2016.
 */
public class UserDaoImpl implements UserDao {
    private static Logger log = Logger.getLogger(HiberConnect.class);

    @Override
    public User getUserByloginAndPassword (String  login, String password) {
        User usr = null;
        SessionFactory factory = getSessionFactory();
        log.info("");

        Session session = null;
        try {
            session = factory.openSession();
            Query getUser = session.createQuery("from User u where u.login=:login and u.password=:password");
            getUser.setParameter("login", login);
            getUser.setParameter("password", password);
            if (getUser.uniqueResult()!=null) {
                usr = (User) getUser.uniqueResult();
            } else {
                System.out.println("getUser.uniqueResult() is null");
            }


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

        return usr;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAllWithoutUser(User user) {

        SessionFactory factory = getSessionFactory();
        log.info("Reference to SessionFactory " + factory);
        List<User>  list=null;
        Session session = null;
        try {
            session = factory.openSession();
            Query getUsers = session.createQuery("from User u where u.login<>:currLogin");
            getUsers.setParameter("currLogin", user.getLogin());
            list = getUsers.list();

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
        return list;
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        return cfg.buildSessionFactory(standardServiceRegistry);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String login=scan.next();
        String password=scan.next();

        UserDaoImpl cur_app = new UserDaoImpl();

        if (cur_app.getUserByloginAndPassword(login, password)!=null) {
            System.out.println("Exist");
        }

    }
}
