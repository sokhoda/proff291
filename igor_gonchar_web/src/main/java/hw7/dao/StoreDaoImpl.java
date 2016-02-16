package hw7.dao;

import hw7.domain.CPU;
import hw7.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            session.save(store);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return null;
    }

    @Override
    public Store read(Long id) {
        Session session = factory.openSession();
        try {
            return (Store) session.get(Store.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        boolean isDeleted = false;
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
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
    public List findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("FROM hw7.domain.Store s");
        return query.list();
    }
}
