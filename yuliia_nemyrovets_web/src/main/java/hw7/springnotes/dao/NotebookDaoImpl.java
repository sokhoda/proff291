package hw7.springnotes.dao;

import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Юлия on 19.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

      public NotebookDaoImpl() {
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(notebook);

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
        Session session = factory.getCurrentSession();
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
        Session session = factory.getCurrentSession();

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
        Session session = factory.getCurrentSession();

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
        Session session = factory.getCurrentSession();
        try {
            Query query = session.createQuery("from Notebook");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
        }

    }
}
