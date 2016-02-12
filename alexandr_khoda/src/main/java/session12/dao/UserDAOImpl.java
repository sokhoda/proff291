package session12.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import session11.HiberConnect;

import java.util.List;
import java.util.Locale;

/**
 * Created by s_okhoda on 07.02.2016.
 */
public class UserDAOImpl implements UserDAO {


    @Override
    public List findUserExceptThis(String login, String pass) {
        Logger log = Logger.getLogger(HiberConnect.class);
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("select u.login, u.pass from User u " +
                    " where u.login = '" + login + "' AND u.pass = '" + pass + "'" );

            if (query.list().size() == 0) {
              query = session.createQuery("select u.login, u.pass from User u");
            }
            else {
              query = session.createQuery("select u.login, u.pass from User u " +
                      " where u.login != '" + login + "' AND u.pass != '" +
                      pass + "'");
            }
            return  query.list();
//            return null;
        }
         catch (HibernateException e) {
            log.error("Open session failed", e);
             return null;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

    @Override
    public long count(long id) {

        Logger log = Logger.getLogger(HiberConnect.class);
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        Session session = null;
        try {
            session = factory.openSession();
            Query query = session.createQuery("select count(*) from User u where u.id >= :id");
            query.setParameter("id", id);
            return  (long)query.uniqueResult();
        }
        catch (HibernateException e) {
            log.error("Open session failed", e);
            return -1;
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
    }

    @Override
    public List finUserByPortion(int startInx, int portionSize) {
        return null;
    }
}
