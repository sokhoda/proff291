package hw7.springnotes.dao;



import hw7.springnotes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
@Repository
public class VendorDaoImpl implements VendorDao {

    public VendorDaoImpl(){}

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Vendor vendor) {

        Long id = null;
            id = (Long)sessionFactory.getCurrentSession().save(vendor);
            return id;
        }

    @Override
    public Vendor read(Long id) {
            return (Vendor) sessionFactory.getCurrentSession().get(Vendor.class, id);
    }

    @Override
    public boolean update(Vendor vendor) {
        try {
            sessionFactory.getCurrentSession().update(vendor);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public boolean delete(Vendor vendor) {
        try {
            sessionFactory.getCurrentSession().delete(vendor);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public List findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery("from hw7.springnotes.domain.Vendor");

        return query.list();
    }

}
