package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by Вадим on 07.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook notebook = null;
        try {
            session.beginTransaction();
            notebook = (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            isUpdated = true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            isDeleted = true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = null;
        try {
            session.beginTransaction();
            query = session.createQuery("from Notebook");
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return (List<Notebook>)query.list();
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        Query query = null;
        try {
            session.beginTransaction();
            query = session.createQuery("from hw6.notes.domain.Notebook nb where nb.model = :model");
            query.setParameter("model", model);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return (List<Notebook>)query.list();
    }

    @Override
    public List<Notebook> findByVendor(String vendor) {
        Session session = factory.openSession();
        Query query = null;
        try {
            session.beginTransaction();
            query = session.createQuery("from hw6.notes.domain.Notebook nb where nb.vendor = :vendor");
            query.setParameter("vendor", vendor);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return (List<Notebook>)query.list();
    }

    @Override
    public List<Notebook> findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        Query query = null;
        try {
            session.beginTransaction();
            query = session.createQuery("from hw6.notes.domain.Notebook nb " +
                    "where nb.price = :price and nb.date = :date");
            query.setParameter("price", price);
            query.setParameter("date", date);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return (List<Notebook>)query.list();
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        Query query = null;
        try {
            session.beginTransaction();
            query = session.createQuery("from hw6.notes.domain.Notebook nb " +
                    "where nb.price >= :priceFrom and nb.price <= :priceTo and " +
                    "nb.date < :date and nb.vendor = :vendor");
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            query.setParameter("date", date);
            query.setParameter("vendor", vendor);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return (List<Notebook>)query.list();
    }
}
