//package hw7.springnotes.dao;
//
//import hw7.springnotes.domain.Vendor;
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
//public class VendorDaoImpl implements VendorDao {
//
//
//    @Autowired
//    private SessionFactory factory;
//
//    public VendorDaoImpl() {
//    }
//
//    @Override
//    public Long create(Vendor vendor) {
//        Session session = factory.getCurrentSession();
//        return (Long)session.save(vendor);
//
//    }
//
//    @Override
//    public Vendor read(Long id) {
//        return (Vendor) factory.getCurrentSession().get(Vendor.class, id);
//    }
//
//    @Override
//    public boolean update(Vendor vendor) {
//        factory.getCurrentSession().update(vendor);
//        return true;
//    }
//
//    @Override
//    public boolean delete(Vendor vendor) {
//        factory.getCurrentSession().delete(vendor);
//        return true;
//
//    }
//
//    @Override
//    public List findAll() {
//        return (List) factory.getCurrentSession().createQuery("from Vendor").list();
//
//    }
//}
