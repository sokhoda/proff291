package spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
@Repository("vendorDao")
public class VendorDaoImpl implements VendorDao {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public VendorDaoImpl() {
    }

    public VendorDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Long create(Vendor vendor) {
        return (Long) getSession().save(vendor);
    }

    @Override
    public Vendor read(Long id) {
        return (Vendor) getSession().get(Vendor.class, id);
    }

    @Override
    public boolean update(Vendor vendor) {
        getSession().update(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        getSession().delete(vendor);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Vendor>) getSession().createQuery("from Vendor").list();

    }

    @Override
    public Vendor findVendorByName(String name) {
        return (Vendor) getSession().createQuery("from Vendor v where v.name = :name ").setString("name", name);
    }

}
