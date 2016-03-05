package hw9.taxi.dao;



import hw9.taxi.domain.Order;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Solyk on 02.03.2016.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public OrderDaoImpl(){}

    @Override
    public Long create(Order order) {
        try {
            return (Long)sessionFactory.getCurrentSession().save(order);
        } catch (HibernateException e){
            return null;
        }

    }

    @Override
    public Order read(Long id) {
        return (Order)sessionFactory.getCurrentSession().get(Order.class, id);
    }

    @Override
    public boolean update(Order order) {
        try{
            sessionFactory.getCurrentSession().update(order);
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Order order) {
        try{
            sessionFactory.getCurrentSession().delete(order);
            return true;
        } catch (HibernateException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from hw9.taxi.domain.Order");
        return query.list();
    }
}
