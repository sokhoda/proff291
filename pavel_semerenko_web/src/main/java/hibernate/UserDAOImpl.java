package hibernate;

import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

/**
 * Created by Pavel on 07.02.2016.
 */
public class UserDAOImpl implements UserDAO {
    SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public UserDAOImpl() {
    }

    @Override
    public void insert() {

    }

    @Override
    public void create() {

    }

    @Override
    public void read() {

    }

    @Override
    public void delete() {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<Object[]> findExceptOne(String name, String pass) {
        Session session = null;
        List<Object[]> resultObj = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("SELECT u.fname, u.sname, u.pass FROM User u " +
                    " WHERE u.fname <> '" + name + "' AND u.pass <> '" + pass + "'");
            resultObj = query.list();
        } catch (HibernateError e){
            if(session != null) {
                session.getTransaction().commit();
            }
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return resultObj;
    }

    @Override
    public List<User> findUsersByPortion(int startWith, int portionSize) {
        Session session = null;
        List<User> resultObj = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("from User");
            query.setFirstResult(startWith);
            query.setMaxResults(portionSize);
            resultObj = query.list();
        } catch (HibernateError e){
            if(session != null) {
                session.getTransaction().commit();
            }
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return resultObj;
    }

    @Override
    public long findCountAll() {
        return 0;
    }
}
