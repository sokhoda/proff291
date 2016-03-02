package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
@Repository
public class SalesDaoImpl implements SalesDao {

    @Autowired
    private SessionFactory factory;

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        return (Long) factory.getCurrentSession().save(sales);
    }

    @Override
    public Sales read(Long id) {
        return (Sales) factory.getCurrentSession().get(Sales.class, id);
    }

    @Override
    public boolean update(Sales sales) {
        factory.getCurrentSession().update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        factory.getCurrentSession().delete(sales);
        return true;

    }

    @Override
    public List findAll() {
        return (List) factory.getCurrentSession().createQuery("from Sales").list();
    }

}

