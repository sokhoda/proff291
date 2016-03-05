package hw7.notes.dao;

import hw7.notes.domain.Vendor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 20.02.2016.
 */
public class VendorDAOImpl implements VendorDAO {
    private SessionFactory factory=null;

    public VendorDAOImpl(SessionFactory factory){
        this.factory=factory;
    }


    @Override
    public Long create(Vendor vendor) {
        Long id=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            id=(Long)session.save(vendor);
            session.getTransaction().commit();
            return id;
        } catch(Exception e){
            session.getTransaction().rollback();
            return id;
        } finally {
            session.close();
        }

    }

    @Override
    public Vendor read(Long id) {
        Vendor aVendor=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            aVendor =(Vendor)session.get(Vendor.class,id);
            session.getTransaction().commit();
            return aVendor;
        } catch(Exception e){
            session.getTransaction().rollback();
            return aVendor;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Vendor vendor) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
            return true;
        } catch(Exception e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Vendor vendor) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(vendor);
            session.getTransaction().commit();
            return true;
        } catch(Exception e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List findAll() {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            Query aQuerry=session.createQuery("from Vendors");
            session.getTransaction().commit();
            return aQuerry.list();
        } catch(Exception e){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }

    }
}
