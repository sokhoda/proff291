package hw7.dao;

import hw7.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public class VendorDaoImpl implements VendorDao {

    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;


    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(vendor);
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
    public Vendor read(Long id) {
        Session session = factory.openSession();
        try {
            return (Vendor) session.get(Vendor.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        boolean isUpdated = false;
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(vendor);
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
    public boolean delete(Vendor vendor) {
        boolean isDeleted = false;
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(vendor);
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
    public List<Vendor> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("FROM hw7.domain.Vendor v");
        return query.list();
    }
}
