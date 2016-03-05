//package hw7.springnotes.dao;
//
//import hw7.springnotes.domain.Store;
//import org.apache.log4j.Logger;
//import org.hibernate.HibernateError;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * Created by Юлия on 19.02.2016.
// */
//@Repository
//public class StoreDaoImpl implements StoreDao {
//
//    @Autowired
//    private SessionFactory factory;
//
//    public StoreDaoImpl() {
//    }
//
//
//    @Override
//    public Long create(Store store) {
//        return (Long) factory.getCurrentSession().save(store);
//    }
//
//    @Override
//    public Store read(Long id) {
//        return (Store) factory.getCurrentSession().get(Store.class, id);
//
//    }
//
//    @Override
//    public boolean update(Store store) {
//        factory.getCurrentSession().update(store);
//        return true;
//    }
//
//    @Override
//    public boolean delete(Store store) {
//        factory.getCurrentSession().delete(store);
//        return true;
//
//    }
//
//    @Override
//    public List findAll() {
//        return (List) factory.getCurrentSession().createQuery("from Stores").list();
//    }
//}
