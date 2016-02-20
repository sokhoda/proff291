package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */
public class StoreDaoImpl implements StoreDao {

    private SessionFactory factory;

    public StoreDaoImpl() {}

    public StoreDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Long)session.save(store);
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
    public Store read(Long id) {
        Session session = factory.openSession();
        Store store = null;
        try {
            store = (Store)session.get(Store.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return store;
    }

    @Override
    public boolean update(Store store) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(store);
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
    public List<Store> findAll() {
        Session session = factory.openSession();
        try {
            return (List<Store>)session.createQuery("FROM Store").list();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Store> findOnStorePresent() {
        Session session = factory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    "select * from NOTEBOOK n, STORE s " +
                            "where n.NOTEBOOK_ID = s.NOTEBOOK_ID"
            );
            query.addEntity(Store.class);
            return query.list();
        } finally {
            session.close();
        }
    }

}
