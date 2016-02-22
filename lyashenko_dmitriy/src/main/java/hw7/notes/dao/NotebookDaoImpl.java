package hw7.notes.dao;



import hw7.notes.damain.Notebook;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    public NotebookDaoImpl(){}

    private SessionFactory sessionFactory = NotebookServiceImpl.getSessionFactory();

    @Override
    public Long create(Notebook notebook) {
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long)session.save(notebook);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(notebook);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(notebook);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook");
        session.close();
        sessionFactory.close();
        return query.list();
    }
}
