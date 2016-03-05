package hw9.taxi.dao;

import hw9.taxi.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 02.03.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory factory;

    public UserDaoImpl() {

    }

    @Override
    public Long create(User user) {
        return (Long)factory.getCurrentSession().save(user);
    }
    @Override
    public User read(Long id) {
        return (User)factory.getCurrentSession().get(User.class,id);
    }

    @Override
    public boolean update(User user) {
        factory.getCurrentSession().update(user);
        return true;
    }

    @Override
    public boolean delete(User user) {
        factory.getCurrentSession().delete(user);
        return true;
    }

    @Override
    public List findAll() {
        return (List) factory.getCurrentSession().createQuery("from User").list();
    }
}
