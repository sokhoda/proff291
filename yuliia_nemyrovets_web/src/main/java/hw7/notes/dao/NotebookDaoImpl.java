package hw7.notes.dao;

import hw7.notes.domain.Notebook;

import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
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
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);
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
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (Exception e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;

    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.update(notebook);
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
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();

        try {
            session.beginTransaction();
            session.delete(notebook);
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
            Query query = session.createQuery("from NOTEBOOKS");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
        }

    }
}
