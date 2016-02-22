package hw7.springnotes.dao;

import hw7.springnotes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */

@Repository("vendorDao")
public class VendorDaoImpl extends GeneralDaoImpl implements VendorDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public VendorDaoImpl() {}

    public Long create(Vendor vendor) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(vendor);
    }

    public Vendor read(Long id) {
        Session session = factory.getCurrentSession();
        return (Vendor)session.get(Vendor.class, id);
    }

    public boolean update(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.update(vendor);
        return true;
    }

    public boolean delete(Vendor vendor) {
        Session session = factory.getCurrentSession();
        session.delete(vendor);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<Vendor> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Vendor>)session.createQuery("from hw7.springnotes.domain.Vendor").list();
    }
}
