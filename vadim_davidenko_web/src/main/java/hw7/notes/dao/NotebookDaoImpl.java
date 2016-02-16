package hw7.notes.dao;

import hw7.notes.domain.Notebook;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    private SessionFactory factory;

    public NotebookDaoImpl() {}

    public NotebookDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Session session = factory.openSession();
        Long id = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Long)session.save(notebook);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        Notebook notebook = null;
        try {
            notebook = (Notebook)session.get(Notebook.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(notebook);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Notebook notebook) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(notebook);
            tx.commit();
            isDeleted = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List<Notebook> findAll() {
        List<Notebook> list = new ArrayList<Notebook>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("FROM hw7.notes.domain.Notebook").list();
            if (result != null) {
                for (Object obj : result) {
                    list.add((Notebook) obj);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    public List<Notebook> findByPortion(int firstResult, int maxResults) {
        List<Notebook> list = new ArrayList<Notebook>();
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM hw7.notes.domain.Notebook");
            query.setFirstResult(firstResult);
            query.setMaxResults(maxResults);
            List result = query.list();
            if (result != null) {
                for (Object obj : result) {
                    list.add((Notebook) obj);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

}
