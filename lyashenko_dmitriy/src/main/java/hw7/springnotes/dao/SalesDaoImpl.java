package hw7.springnotes.dao;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import hw7.springnotes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 17.02.2016.
 */
@Repository
public class SalesDaoImpl implements SalesDao {

    public  SalesDaoImpl (){}

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Sales sales) {

        Long id = null;
            id = (Long)sessionFactory.getCurrentSession().save(sales);
            return id;

    }

    @Override
    public Sales read(Long id) {
            return (Sales) sessionFactory.getCurrentSession().get(Sales.class, id);
    }

    @Override
    public boolean update(Sales sales) {

        try {
            sessionFactory.getCurrentSession().update(sales);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public boolean delete(Sales sales) {
        try {
            sessionFactory.getCurrentSession().delete(sales);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public List findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery("from hw7.springnotes.domain.Sales");

        return query.list();
    }

    @Override
    public Map getSalesByDays() {
        return new LinkedHashMap<Date, Integer>();
    }
}
