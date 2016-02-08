package hw5.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.HiberConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by v.davidenko on 03.02.2016.
 */
public class UserHibernateManager {

    private static Logger log = Logger.getLogger(HiberConnect.class);
    private static SessionFactory factory = getSessionFactory();

    public int create(User user) throws SQLException {
        int id = 0;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Integer)session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        return id;
    }

    public List<User> findAll() throws SQLException {
        List<User> usersList = new ArrayList<User>();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM hw5.User");
            List results = query.list();
            for(Object res : results) {
                usersList.add((User)res);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        return usersList;
    }

    public User readByNamePass(String login, String pass) throws SQLException {
        User user = null;
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String hql = "FROM hw5.User WHERE hw5.User.name =" + login + "AND hw11.User.password =" + pass;
            Query query = session.createQuery(hql);
            user = (User)query.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            log.error("Open session failed", e);
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        return user;
    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw5/hibernate/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        return factory;
    }

}
