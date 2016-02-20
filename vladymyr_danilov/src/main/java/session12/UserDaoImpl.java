package session12;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SessionFactory factory;

    public UserDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long cerate(User user) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long)session.save(user);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
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
            return (User)session.get(User.class, id);
        } catch (HibernateException e) {
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
    public List<User> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from User");
        List<User> users = (List) query.list();

        return users;
    }

    @Override
    public List<User> findAllByLogin(String name, String password) {
        Session session = factory.openSession();
        Query query = session.createQuery("select r.name from User r where r.name != name r.password != password");

        return null;
    }
}
