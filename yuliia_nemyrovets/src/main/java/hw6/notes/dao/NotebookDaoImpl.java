package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Юлия on 12.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public NotebookDaoImpl() {

    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateError e) {
            log.error("Transaction is failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;

    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (Exception e) {
            log.error("Transaction is failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;


    }


    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateError e) {
            log.error("Transaction is failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateError e) {
            log.error("Transaction is failed");
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }

        }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Notebook");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is failed");
            return null;
        } finally {
            session.close();
        }

    }

    @Override
    public List findByModel(String model) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Notebook n where n.model = :model");
          query.setParameter("model", model);
           return query.list();
        } catch (Exception e) {
            log.error("Transaction is failed");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List findByVendor(String vendor) {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Notebook n where n.vendor = :vendor");
            query.setParameter("vendor", vendor);
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is failed");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        Session session = factory.openSession();
        SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy");
        try {
            Query query = session.createQuery("from Notebook n where n.price = :price and n.date = : date");
            query.setParameter("price", price);
            query.setParameter("date", date);
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is failed");
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = factory.openSession();
        SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy");
        try {
            Query query = session.createQuery("from Notebook n where n.price > :priceFrom and n.price < :priceTo  and n.date = : date and vendor = :vendor");
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            query.setParameter("date", date);
            query.setParameter("vendor", vendor);
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is failed");
            return null;
        } finally {
            session.close();
        }
}}
