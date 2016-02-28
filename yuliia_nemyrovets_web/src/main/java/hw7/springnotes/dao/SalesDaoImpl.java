package hw7.springnotes.dao;

import hw7.notes.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
public class SalesDaoImpl implements SalesDao {

    private static Logger log = Logger.getLogger(SalesDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

    public SalesDaoImpl() {
    }

    @Override
    public Long create(Sales sales) {
        Session session = factory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(sales);
            return id;
        } catch (HibernateError e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;

    }

    @Override
    public Sales read(Long id) {
        Session session = factory.getCurrentSession();
        try {
            return (Sales) session.get(Sales.class, id);
        } catch (Exception e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public boolean update(Sales sales) {
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;
        } catch (HibernateError e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean delete(Sales sales) {
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(sales);
            return true;
        } catch (HibernateError e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public List findAll() {
        Session session = factory.getCurrentSession();
        try {
            Query query = session.createQuery("from Sales");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
        }

    }

}

