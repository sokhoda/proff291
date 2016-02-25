package hw7.dao;

import hw7.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@Repository("vendorDao")
public class VendorDaoImpl implements VendorDao {

    /* Before Spring
    private SessionFactory factory;

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

     @Override
    public Long create(Vendor vendor) {
        Session session = mySessionFactory.openSession();
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
    }*/

    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    public VendorDaoImpl() {
    }

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    @Override
    public Long create(Vendor vendor) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(vendor);
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Vendor) session.get(Vendor.class, id);

    }

    @Override
    public boolean update(Vendor vendor) {
        boolean isUpdated = false;
        Session session = mySessionFactory.getCurrentSession();
        session.update(vendor);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean delete(Vendor vendor) {
        boolean isDeleted = false;
        Session session = mySessionFactory.getCurrentSession();
        session.delete(vendor);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw7.domain.Vendor v");
        return query.list();
    }
}
