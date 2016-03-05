package hw9.taxi.dao;


import hw9.taxi.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Solyk on 01.03.2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl(){}

    @Override
    public Long create(User user) {
        try {
            return (Long)sessionFactory.getCurrentSession().save(user);
        } catch (HibernateException e){
            return null;
        }

    }

    @Override
    public User read(Long id) {
        return (User)sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public boolean update(User user) {
        try{
            sessionFactory.getCurrentSession().update(user);
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(User user) {
        try{
            sessionFactory.getCurrentSession().delete(user);
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from hw9.taxi.domain.User");
        return query.list();
    }
}
