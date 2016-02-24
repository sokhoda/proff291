package hw7.dao;

import hw7.domain.CPU;
import hw7.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@Repository("salesDao")
public class SalesDaoImpl implements SalesDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(sales);
        return id;
    }

    @Override
    public Sales read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Sales) session.get(Sales.class, id);
    }

    @Override
    public boolean update(Sales sales) {
        Session session = mySessionFactory.getCurrentSession();
        boolean isUpdated = false;
        session.update(sales);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean delete(Sales sales) {
        boolean isDeleted = false;
        Session session = mySessionFactory.getCurrentSession();
        session.delete(sales);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List findall() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw7.domain.Sales s");
        return query.list();
    }
}
