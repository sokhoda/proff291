package hw7.dao;

import hw7.domain.CPU;
import hw7.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public class NotebookDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;

    public NotebookDaoImpl (SessionFactory sessionFactory){
        this.factory = sessionFactory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            session.save(notebook);
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
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(notebook);
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
    public boolean delete(Notebook notebook) {
        boolean isDeleted = false;
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
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
        Query query = session.createQuery("FROM hw7.domain.Notebook n");
        return query.list();
    }
}
