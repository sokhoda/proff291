package hw9.dao;

import hw9.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public OrderDaoImpl() {

    }

    @Override
    public long create(Order order) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(order);
        return id;
    }

    @Override
    public boolean update(Order order) {
        Session session = mySessionFactory.getCurrentSession();
        session.update(order);
        return true;
    }

    @Override
    public boolean delete(Order order) {
        Session session = mySessionFactory.getCurrentSession();
        session.delete(order);
        return true;
    }

    @Override
    public Order read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Order) session.get(Order.class, id);
    }

    @Override
    public Order findByAddressFromAndTo(String addressFrom, String addressTo) {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw9.domain.Order o WHERE o.addressFrom =:addressFrom AND o.addressTo =:addressTo");
        query.setString ("addressFrom", addressFrom);
        query.setString ("addressTo", addressTo);
        return (Order) query.uniqueResult();
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw9.domain.Order o");
        return query.list();
    }
}
