package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;

    public StoreDaoImpl() {
    }

    public StoreDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(store);
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
    public Store read(Long id) {
        Session session = factory.openSession();
        Store store = null;

        try {
            session.beginTransaction();
            store = (Store) session.get(Store.class, id);
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
        boolean isUpdate = false;

        try {
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        Session session = factory.openSession();
        boolean isDelete = false;

        try {
            session.beginTransaction();
            session.delete(store);
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
    public List<Store> findAll() {
        Session session = factory.openSession();
        List<Store> list = new ArrayList<>();

        try {
            session.beginTransaction();
            List query = (List) session.createQuery("from hw7.notes.domain.Store");
            if ( query != null ) {
                for ( Object object : query ) {
                    list.add((Store) object);
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
