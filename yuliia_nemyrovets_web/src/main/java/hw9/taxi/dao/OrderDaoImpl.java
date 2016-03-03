package hw9.taxi.dao;

import hw9.taxi.domain.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 02.03.2016.
 */
@Repository
public class OrderDaoImpl implements OrderDao{
    @Autowired
    private SessionFactory factory;

    public OrderDaoImpl() {

    }

    @Override
    public Long create(Order order) {
        return (Long)factory.getCurrentSession().save(order);
    }
    @Override
    public Order read(Long id) {
        return (Order)factory.getCurrentSession().get(Order.class,id);
    }

    @Override
    public boolean update(Order order) {
        factory.getCurrentSession().update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        factory.getCurrentSession().delete(order);
        return true;
    }

    @Override
    public List findAll() {
        return (List) factory.getCurrentSession().createQuery("from Order").list();
    }
}
