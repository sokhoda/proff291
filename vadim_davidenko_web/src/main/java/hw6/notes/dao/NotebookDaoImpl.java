package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Вадим on 07.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    final static Integer BATCH_SIZE = 20;

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
            notebook = (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
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
        List<Notebook> list = new ArrayList<Notebook>();
        Session session = factory.openSession();
        try {
            ScrollableResults noteCursor = session.createQuery("FROM hw6.notes.domain.Notebook").scroll();
            int count = 0;

            while (noteCursor.next()) {
                Notebook note = (Notebook) noteCursor.get(0);
                list.add(note);
                if (++count % BATCH_SIZE == 0) {
                    session.flush();
                    session.clear();
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Notebook> findByModel(String model) {
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("FROM hw6.notes.domain.Notebook nb WHERE nb.model = :model");
            query.setParameter("model", model);
        } catch (HibernateException e) {
            e.printStackTrace();
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
            query = session.createQuery("FROM hw6.notes.domain.Notebook nb WHERE nb.vendor = :vendor");
            query.setParameter("vendor", vendor);
        } catch (HibernateException e) {
            e.printStackTrace();
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
            query = session.createQuery("FROM hw6.notes.domain.Notebook nb " +
                    "WHERE nb.price = :price AND nb.date = :date");
            query.setParameter("price", price);
            query.setParameter("date", date);
        } catch (HibernateException e) {
            e.printStackTrace();
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
            query = session.createQuery("FROM hw6.notes.domain.Notebook nb " +
                    "WHERE nb.price >= :priceFrom AND nb.price <= :priceTo AND " +
                    "nb.date < :date and nb.vendor = :vendor");
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            query.setParameter("date", date);
            query.setParameter("vendor", vendor);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return (List<Notebook>)query.list();
    }

    public int countNotebookRecords(String request) {
        String hql = "SELECT COUNT (*) " + request;
        int counter = 0;
        Session session = factory.openSession();
        Query query = null;
        try {
            session.beginTransaction();
             counter = session.createQuery(hql).getFirstResult();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return counter;

    }
}
