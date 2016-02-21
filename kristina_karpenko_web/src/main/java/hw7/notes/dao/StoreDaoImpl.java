package hw7.notes.dao;

import hw7.notes.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public StoreDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }


    @Override
    public Long create(Store store) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(store);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
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
        try {
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        try {
            session.beginTransaction();
            session.delete(store);
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
        List<Store> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("from hw7.notes.domain.Store").list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((Store)vend);
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
