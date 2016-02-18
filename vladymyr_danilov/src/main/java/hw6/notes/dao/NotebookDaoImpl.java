package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


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
        } catch (HibernateException e) {
            log.error("Transaction error");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook ntb = null;

        try {
            ntb = (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction error");
        } finally {
            session.close();
        }

        return ntb;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        boolean isUpdated = false;

        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            isUpdated = true;
        } catch (HibernateException e) {
            log.error("Transaction error");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return isUpdated;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        boolean isDeleted = false;

        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            isDeleted = true;
        } catch (HibernateException e) {
            log.error("Transaction error");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }

        return isDeleted;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        List<Notebook> notebooks = null;

        try {
            Query query = session.createQuery("from Notebook");
            notebooks = (List) query.list();
        } catch (HibernateException e) {
            log.error("Query error");
        } finally {
            session.close();
        }

        return notebooks;
    }
}
