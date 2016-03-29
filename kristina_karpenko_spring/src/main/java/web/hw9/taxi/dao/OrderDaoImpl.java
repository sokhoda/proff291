package web.hw9.taxi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.hw9.taxi.domain.Order;

import java.util.List;

/**
 * Created by Администратор on 14.03.2016.
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
    @Autowired(required = true)
    SessionFactory factory;

    public OrderDaoImpl() {
    }

    public OrderDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    protected Session getSession() {
        return factory.getCurrentSession();

    }

    @Override
    public Long create(Order order) {
        return (Long)getSession().save(order);
    }

    @Override
    public Order read(Long id) {
        return (Order)getSession().get(Order.class,id);
    }

    @Override
    public boolean update(Order order) {
        getSession().update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        getSession().delete(order);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Order>)getSession().createQuery("from web.hw9.taxi.domain.Order o");
    }

    @Override
    public List showOrdersSum(double min, double max) {
       // return getSession().createQuery("from web.hw9.taxi.domain.Order o join o.client c where o.amount >= :min and o.amount <= :max")
        return getSession().createQuery("from web.hw9.taxi.domain.Order o where o.amount >= :min and o.amount <= :max")
                .setParameter("min",min)
                .setParameter("max",max)
                .list();
    }

    @Override
    public List showOrdersByPortion(int page, int portionSize) {
        return (List<Order>) getSession().createQuery("from web.hw9.taxi.domain.Order c")
                .setFirstResult(page*portionSize-portionSize)
                .setMaxResults(portionSize).list();
    }
}

