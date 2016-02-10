package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by s_okhoda on 09.02.2016.
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
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
        } finally {
             session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        if (id == null) {
            return null;
        }
        Session session = factory.openSession();
        Notebook notebook = null;
        try {
            notebook = (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
        } finally {
            session.close();
        }
        return notebook;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
//            Query query = session.createQuery("UPDATE Notebook n set SERIAL = :SERIAL, VENDOR = :VENDOR" +
//                    ", MODEL = :MODEL, MANDATE = :MANDATE, PRICE = :PRICE where ID = :ID");
//
//            query.setParameter("ID", ntb.getId());
//            query.setParameter("SERIAL", ntb.getSerial());
//            query.setParameter("VENDOR", ntb.getVendor());
//            query.setParameter("MODEL", ntb.getModel());
//            query.setParameter("MANDATE", ntb.getManDate());
//            query.setParameter("PRICE", ntb.getPrice());
//            intRes = query.executeUpdate();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Notebook ntb) {
        if (ntb == null){
            return false;
        }
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public List<Notebook> findAll() {
        Session session = factory.openSession();
        try {
           Query query = session.createQuery("from Notebook");
           return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
            return null;
        } finally {
            session.close();
        }
    }
}
