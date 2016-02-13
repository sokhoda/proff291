package session12;

import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Юлия on 07.02.2016.
 */
public class UserDAOImpl implements UserDAO {

    private static Logger log = Logger.getLogger(UserDAOImpl.class);
    private SessionFactory factory;

    public UserDAOImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public UserDAOImpl() {

    }


    @Override
    public Long create(User user) {

        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(user);
            session.getTransaction().commit();
            return id;
        } catch (HibernateError e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;


    }

    @Override
    public User read(Long id) {
        Session session = factory.openSession();
        try {
            return (User) session.get(User.class, id);
        } catch (Exception e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List findAll(String name, int id) {
        List<User> list = new ArrayList<>();

        Session session = factory.openSession();
        try {
            Query query = session.createQuery("select u.name, u.id, u.password,u.login, u.date  from User u where u.id != " + id + " or u.name not like '" + name + "'");

            List<Object[]> list2 = query.list();

            System.out.println(Arrays.toString(list2.get(0)));
            System.out.println(Arrays.toString(list2.get(1)));
            System.out.println(Arrays.toString(list2.get(2)));
            return query.list();
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

        return list;
    }

    @Override
    public List showByPortion(int id) {
        List<User> list = new ArrayList<>();
        int portionSize = 3;
        Session session = factory.openSession();
        try {
            Query query = session.createQuery(" from User u   ");

            List<Object[]> list2 = query.list();

            List count;
            for (int i = 0; (list2 = query.list()).size() != 0; i += portionSize) {
                query.setFirstResult(i);
                query.setMaxResults(portionSize);
                System.out.println(list2);

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

        return list;
    }
}