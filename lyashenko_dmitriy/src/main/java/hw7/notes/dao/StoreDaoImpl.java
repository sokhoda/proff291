package hw7.notes.dao;


import hw7.notes.domain.Notebook;
import hw7.notes.domain.Store;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public class StoreDaoImpl implements StoreDao {

    public StoreDaoImpl (){}

    private SessionFactory sessionFactory;

    @Override
    public Long create(Store store) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long)session.save(store);
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
    public Store read(Long id) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            return (Store) session.get(Store.class, id);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean update(Store store) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(store);
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
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Store");
        session.close();
        sessionFactory.close();
        return query.list();
    }

    @Override
    public List getNotebooksGtAmount(int amount) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            Query query = session.createQuery("select  Notebook as notebook from Store s  where s.quantity > :amount")
            .setParameter("amount", amount);
            return query.list();
        }catch (HibernateException e){
            e.printStackTrace();
            return null;
        }finally {
            session.close();
            sessionFactory.close();
        }


    }
}
