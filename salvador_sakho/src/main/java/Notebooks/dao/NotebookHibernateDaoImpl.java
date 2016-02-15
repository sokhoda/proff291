package Notebooks.dao;

import Notebooks.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 08.02.2016.
 */
public class NotebookHibernateDaoImpl implements NotebookDao {
    private static Logger log = Logger.getLogger(NotebookHibernateDaoImpl.class);
    private SessionFactory sessionFactory;

    public NotebookHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public NotebookHibernateDaoImpl() {
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
    public void update(Notebook note) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Scanner scan = new Scanner(System.in);
            System.out.println("Put new price");
            Long newPrice = scan.nextLong();
            System.out.println("Put id of notebook where you want to change the price");
            Long noteId = scan.nextLong();
            Query query = session.createQuery("update Notebook n set n.PRICE= " + newPrice + " where n.id= " + noteId);
            query.setParameter("PRICE", newPrice);
            session.getTransaction().commit();

            System.out.println("Update of price for computer " + note.getId());
        } catch (HibernateException e) {

            System.out.println("class=NotebookHibernateDaoImpl; Method=update");
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Notebook note) {

    }

    @Override
    public boolean delete(Long id) {
        Long idForDelete = id;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Notebook n where n.id=" + idForDelete);
        query.setParameter("idForDelete", idForDelete);
        session.getTransaction().commit();
        System.out.println("Notebook which has id " + idForDelete + " was deleted");
        return true;
    }

    @Override
    public List<Notebook> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook");
        return query.list();
    }
}
