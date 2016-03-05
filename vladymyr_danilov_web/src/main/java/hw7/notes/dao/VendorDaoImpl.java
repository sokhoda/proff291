package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class VendorDaoImpl implements VendorDao {
    private SessionFactory factory;

    public VendorDaoImpl() {
    }

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
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return id;
    }

    @Override
    public Vendor read(Long id) {
        Session session = factory.openSession();
        Vendor vendor = null;

        try {
            session.beginTransaction();
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
        boolean isUpdate = false;

        try {
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            isUpdate = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isUpdate;
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session = factory.openSession();
        boolean isDelete = false;

        try {
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            isDelete = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isDelete;
    }

    @Override
    public List<Vendor> findAll() {
        Session session = factory.openSession();
        List<Vendor> list = new ArrayList<>();

        try {
            session.beginTransaction();
            List query = (List) session.createQuery("from hw7.notes.domain.Vendor");
            if ( query != null ) {
                for ( Object object : query ) {
                    list.add((Vendor) object);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return list;
    }
}
