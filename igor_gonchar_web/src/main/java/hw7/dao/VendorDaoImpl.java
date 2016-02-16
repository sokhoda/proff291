package hw7.dao;

import hw7.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
public class VendorDaoImpl implements VendorDao{

    private static Logger log = Logger.getLogger(VendorDaoImpl.class);
    private SessionFactory factory;


    public VendorDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    @Override
    public Long create(Vendor vendor) {
        Session session = factory.openSession();

       /* try {
            session.beginTransaction();
            id = (Long)session.save(user);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }*/

        return null;
    }

    @Override
    public Vendor read(Long id) {
        return null;
    }

    @Override
    public boolean update(Vendor vendor) {
        return false;
    }

    @Override
    public boolean delete(Vendor vendor) {
        return false;
    }

    @Override
    public List findAll() {
        return null;
    }
}
