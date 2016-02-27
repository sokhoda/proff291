package laptopshop.dao;

import laptopshop.domain.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
@Repository
public class VendorDaoImpl implements VendorDao {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public VendorDaoImpl() {
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(vendor);
    }

    @Override
    public Vendor read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Vendor) session.get(Vendor.class, id);
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(vendor);
        return true;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Vendor>) session.createQuery("FROM Vendor").list();
    }
}
