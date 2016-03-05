package hw7.dao;

import hw7.domain.CPU;
import hw7.domain.Store;
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
@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    public StoreDaoImpl() {
    }

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    @Override
    public Long create(Store store) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(store);
        return id;
    }

    @Override
    public Store read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Store) session.get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        Session session = mySessionFactory.getCurrentSession();
        boolean isUpdated = false;
        session.update(store);

        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean delete(Store store) {
        boolean isDeleted = false;
        Session session = mySessionFactory.getCurrentSession();
        session.delete(store);
        session.getTransaction().commit();
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw7.domain.Store s");
        return query.list();
    }
}
