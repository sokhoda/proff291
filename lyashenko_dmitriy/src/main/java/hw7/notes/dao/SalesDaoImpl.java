package hw7.notes.dao;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import hw7.notes.domain.Sales;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Admin on 17.02.2016.
 */
public class SalesDaoImpl implements SalesDao {

    public  SalesDaoImpl (){}

    private SessionFactory sessionFactory;

    @Override
    public Long create(Sales sales) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long)session.save(sales);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public Sales read(Long id) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            return (Sales) session.get(Sales.class, id);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean update(Sales sales) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean delete(Sales sales) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public List findAll() {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Sales");
        session.close();
        sessionFactory.close();
        return query.list();
    }

    @Override
    public Map getSalesByDays() {
        return new LinkedHashMap<Date, Integer>();
    }
}
