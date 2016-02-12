package Notebooks.dao;

import Notebooks.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by User on 08.02.2016.
 */
public class NotebookHibernateDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookHibernateDaoImpl.class);
    private SessionFactory sessionFactory;

    public NotebookHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long createNote(Notebook note) {
        Session sessionNote = sessionFactory.openSession();
        Long id = null;
        try {
            sessionNote.beginTransaction();
            id = (Long) sessionNote.save(note);
            sessionNote.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            sessionNote.getTransaction().rollback();
        } finally {
            sessionNote.close();
        }
        return id;
    }

    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
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
    public void update(Notebook note) {

    }

    @Override
    public void delete(Notebook note) {

    }

    @Override
    public List<Notebook> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();
    }

//    @Override
//    public List<Notebook> findMonyGT(long amount) {
//        return null;
//    }
}
