package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
public class MemoryDaoImpl implements MemoryDao {

    private static Logger log = Logger.getLogger(MemoryDaoImpl.class);
    private SessionFactory factory;

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public MemoryDaoImpl() {
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
        } catch (HibernateError e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;


    }

    @Override
    public Memory read(Long id) {
        Session session = factory.openSession();
        try {
            return (Memory) session.get(Memory.class, id);
        } catch (Exception e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;


    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(memory);
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
    public List findAll() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from MEMORY");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
        }

    }
}
