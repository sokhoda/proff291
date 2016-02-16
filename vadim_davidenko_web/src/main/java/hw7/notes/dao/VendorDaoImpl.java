package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */
public class VendorDaoImpl implements VendorDao {

    private SessionFactory factory;

    public VendorDaoImpl() {}

    public VendorDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();
        Long id = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Long)session.save(vendor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = factory.openSession();
        Vendor vendor = null;
        try {
            vendor = (Vendor)session.get(Vendor.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return vendor;
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(vendor);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(vendor);
            tx.commit();
            isDeleted = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List<Vendor> findAll() {
        List<Vendor> list = new ArrayList<Vendor>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("FROM hw7.notes.domain.Vendor").list();
            if (result != null) {
                for (Object obj : result) {
                    list.add((Vendor) obj);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
}
