package hw7.notes.dao;


import hw7.notes.domain.Store;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public class StoreDaoImpl implements StoreDao {
    private SessionFactory factory;

    public StoreDaoImpl(){};
    public StoreDaoImpl(SessionFactory factory){
        this.factory=factory;
    };

    @Override
    public Long create(Store store) {
        Long id=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            id=(Long)session.save(store);
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
    public Store read(Long id) {
        Store aStore=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            aStore =(Store) session.get(Store.class,id);
            session.getTransaction().commit();
            return aStore;
        } catch(Exception e){
            session.getTransaction().rollback();
            return aStore;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Store store) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(store);
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
    public boolean delete(Store store) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(store);
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
            Query aQuerry=session.createQuery("from Store");
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
