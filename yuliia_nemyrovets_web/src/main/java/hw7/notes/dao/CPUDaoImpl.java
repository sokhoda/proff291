//package hw7.notes.dao;
//
//import hw7.notes.domain.CPU;
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
//public class CPUDaoImpl implements CPUDao {
//    private static Logger log = Logger.getLogger(CPUDaoImpl.class);
//    private SessionFactory factory;
//
//    public CPUDaoImpl(SessionFactory factory) {
//        this.factory = factory;
//    }
//
//    @Override
//    public Long create(CPU cpu) {
//        Session session = factory.openSession();
//        Long id = null;
////        try {
//            session.beginTransaction();
//            id = (Long) session.save(cpu);
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
//    public CPU read(Long id) {
//        Session session = factory.openSession();
//        try {
//            return (CPU) session.get(CPU.class, id);
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            session.getTransaction().rollback();
//        } finally {
//            session.close();
//        }
//        return null;
//
//
//    }
//
//    @Override
//    public boolean update(CPU cpu) {
//        Session session = factory.openSession();
//        try {
//            session.beginTransaction();
//            session.update(cpu);
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
//    public boolean delete(CPU cpu) {
//        Session session = factory.openSession();
//
//        try {
//            session.beginTransaction();
//            session.delete(cpu);
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
//
//    }
//
//    @Override
//    public List findAll() {
//        Session session = factory.openSession();
//        try {
//            Query query = session.createQuery("from CPU");
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//        }
//
//    }
//
//}
//
