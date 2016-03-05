//package hw7.notes.dao;
//
//import hw7.notes.domain.Notebook;
//
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
//public class NotebookDaoImpl implements NotebookDao {
//    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
//    private SessionFactory factory;
//
//    public NotebookDaoImpl(SessionFactory factory) {
//        this.factory = factory;
//    }
//
//    public NotebookDaoImpl() {
//    }
//
//
//
//
//    @Override
//    public Long create(hw7.springnotes.domain.Notebook notebook) {
//        return null;
//    }
//
//    @Override
//    public hw7.springnotes.domain.Notebook read(Long id) {
//        return null;
//    }
//
//    @Override
//    public boolean update(hw7.springnotes.domain.Notebook notebook) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(hw7.springnotes.domain.Notebook notebook) {
//        return false;
//    }
//
//    @Override
//    public List findAll() {
//        Session session = factory.openSession();
//        try {
//            Query query = session.createQuery("from NOTEBOOKS");
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
