package hw7.notes.dao;


import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
public class VendorDaoImpl implements VendorDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public VendorDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
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
        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = factory.openSession();
        Vendor vendor = null;
        try {
            vendor = (Vendor) session.get(Vendor.class, id);
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
        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            isUpdated = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
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
        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();

            isDeleted = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List findAll() {
        List<Vendor> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("from Vendor").list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((Vendor) vend);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
    @Override
    public Vendor findVendorByName(String name) {
        Session session = factory.openSession();
        Vendor vendor = null;
        try {
            List<Vendor> vend = session.createQuery("from Vendor v where v.name = :name ").setString("name", name).list();

            for (Vendor vendor1 : vend) {
                vendor = vendor1;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return vendor;
    }

}
