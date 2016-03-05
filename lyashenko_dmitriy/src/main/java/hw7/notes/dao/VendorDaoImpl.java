package hw7.notes.dao;


import hw7.notes.domain.Vendor;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public class VendorDaoImpl implements VendorDao {

    public VendorDaoImpl(){}

    private SessionFactory sessionFactory;

    @Override
    public Long create(Vendor vendor) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long)session.save(vendor);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return null;
        } finally {

            session.close();
           sessionFactory.close();
            System.out.println("Closed");

        }
        }

    @Override
    public Vendor read(Long id) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            return (Vendor) session.get(Vendor.class, id);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean update(Vendor vendor) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
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
        Query query = session.createQuery("from hw7.notes.domain.Vendor");
        session.close();
        sessionFactory.close();
        return query.list();
    }

}
