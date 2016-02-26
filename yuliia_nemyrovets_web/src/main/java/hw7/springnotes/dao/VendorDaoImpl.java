package hw7.springnotes.dao;

import hw7.notes.domain.Vendor;
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
public class VendorDaoImpl implements VendorDao {

    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

    public VendorDaoImpl() {
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.getCurrentSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(vendor);
            session.getTransaction().commit();
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
    public Vendor read(Long id) {
        Session session = factory.getCurrentSession();
        try {
            return (Vendor) session.get(Vendor.class, id);
        } catch (Exception e) {
            log.error("Transaction is being failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;


    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.delete(vendor);
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
            Query query = session.createQuery("from Vendor");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
        }


    }
}
