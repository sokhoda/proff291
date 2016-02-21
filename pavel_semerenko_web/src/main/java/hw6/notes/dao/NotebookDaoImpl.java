package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Pavel on 10.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {
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
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
        } catch (HibernateException e){
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook result = null;
        try {
            result = (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {

        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Notebook");
            return query.list();
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
        }
    }
}
