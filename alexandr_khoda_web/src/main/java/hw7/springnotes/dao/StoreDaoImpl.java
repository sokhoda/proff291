package hw7.springnotes.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by s_okhoda on 16.02.2016.
 */
@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(StoreDao.class);
    private SessionFactory factory;

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(hw7.springnotes.domain.Store store) throws HibernateException {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(store);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            throw new HibernateException(e.getMessage() + ", " + e.getCause()
                    .getMessage());
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public hw7.springnotes.domain.Store read(Long id) {
        if (id == null) {
            return null;
        }
        Session session = factory.openSession();
        hw7.springnotes.domain.Store store = null;
        try {
            store = (hw7.springnotes.domain.Store) session.get(hw7.springnotes.domain.Store.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
        } finally {
            session.close();
        }
        return store;
    }

    @Override
    public boolean update(hw7.springnotes.domain.Store store) {
        if (store == null){
            return false;
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(hw7.springnotes.domain.Store store) {
        if (store == null){
            return false;
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
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
            Query query = session.createQuery("from Store");
            return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            return null;
        } finally {
            session.close();
        }
    }
}
