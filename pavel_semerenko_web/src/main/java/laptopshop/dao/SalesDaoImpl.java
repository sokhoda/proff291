package laptopshop.dao;

import laptopshop.domain.Sales;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
@Repository
public class SalesDaoImpl implements SalesDao {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(sales);
    }

    @Override
    public Sales read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Sales) session.get(Sales.class, id);
    }

    @Override
    public boolean update(Sales sales) {
        Session session = sessionFactory.getCurrentSession();
        session.update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(sales);
        return true;
    }

    @Override
    public List<Sales> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Sales>) session.createQuery("FROM laptopshop.domain.Sales").list();
    }
}
