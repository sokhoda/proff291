package hw7.dao;

import hw7.domain.Memory;
import hw7.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public class MemoryDaoImpl implements MemoryDao{
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(memory);
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
    public Memory read(Long id) {
        Session session = factory.openSession();
        try {
            return (Memory) session.get(Memory.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        try {
            session.beginTransaction();
            session.delete(memory);
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
        Query query = session.createQuery("FROM hw7.domain.Memory m");
        return query.list();
    }
}
