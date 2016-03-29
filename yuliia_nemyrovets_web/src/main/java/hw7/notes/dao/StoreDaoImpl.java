//package hw7.notes.dao;
//
//import hw7.notes.domain.Store;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateError;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import java.util.List;
//
///**
// * Created by Юлия on 19.02.2016.
// */
//public class StoreDaoImpl implements StoreDao {
//
//    private static Logger log = Logger.getLogger(StoreDaoImpl.class);
//    private SessionFactory factory;
//
//    public StoreDaoImpl(SessionFactory factory) {
//        this.factory = factory;
//    }
//
//    public StoreDaoImpl() {
//    }
//
//
//    @Override
//    public Long create(Store store) {
//        Session session = factory.openSession();
//        Long id = null;
//        try {
//            session.beginTransaction();
//            id = (Long) session.save(store);
//            session.getTransaction().commit();
//            return id;
//        } catch (HibernateError e) {
//            log.error("Transaction is being failed");
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//        }
//        return id;
//
//    }
//
//    @Override
//    public Store read(Long id) {
//        Session session = factory.openSession();
//        try {
//            return (Store) session.get(Store.class, id);
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//        }
//        return null;
//
//    }
//
//    @Override
//    public boolean update(Store store) {
//        Session session = factory.openSession();
//
//        try {
//            session.beginTransaction();
//            session.update(store);
//            session.getTransaction().commit();
//            return true;
//        } catch (HibernateError e) {
//            log.error("Transaction is being failed");
//            session.getTransaction().rollback();
//            return false;
//        } finally {
//            session.close();
//        }
//
//    }
//
//    @Override
//    public boolean delete(Store store) {
//        Session session = factory.openSession();
//
//        try {
//            session.beginTransaction();
//            session.delete(store);
//            session.getTransaction().commit();
//            return true;
//        } catch (HibernateError e) {
//            log.error("Transaction is being failed");
//            session.getTransaction().rollback();
//            return false;
//        } finally {
//            session.close();
//        }
//
//    }
//
//    @Override
//    public List findAll() {
//        Session session = factory.openSession();
//        try {
//            Query query = session.createQuery("from STORES");
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//        }
//
//    }
//}
