package hw7.springnotes.dao;

import hw7.notes.domain.CPU;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
@Repository("cpu")
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(CPUDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

    @Override
    public Long create(CPU cpu) {
        Session session = factory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(cpu);
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
    public CPU read(Long id) {
        Session session = factory.getCurrentSession();
        try {
            return (CPU) session.get(CPU.class, id);
        } catch (Exception e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;


    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(CPU cpu) {
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(cpu);
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
        Session session = factory.getCurrentSession();
        try {
            Query query = session.createQuery("from CPU");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
        }

    }

}

