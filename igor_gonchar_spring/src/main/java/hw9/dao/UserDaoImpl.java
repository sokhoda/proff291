package hw9.dao;

import hw9.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 2/29/2016.
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public UserDaoImpl() {
    }

    @Override
    public long createUser(User user) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(user);
        return 0;
    }

    @Override
    public boolean update(User user) {
        Session session = mySessionFactory.getCurrentSession();
        session.update(user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        Session session = mySessionFactory.getCurrentSession();
        session.delete(user);
        return true;
    }

    @Override
    public User read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw9.domain.User u");
        return query.list();
    }
}
