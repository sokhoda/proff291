package hw6.notes.dao;


import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Rrr on 09.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(ntb);
            session.getTransaction().commit();
            return id;
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
        try {
            return (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
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
            //getCurrentSession().delete(entity);
            session.update(ntb);
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.delete(ntb);
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;

    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();
    }

}
