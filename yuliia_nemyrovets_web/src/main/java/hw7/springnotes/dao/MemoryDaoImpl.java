//package hw7.springnotes.dao;
//
//import hw7.springnotes.domain.Memory;
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
//public class MemoryDaoImpl implements MemoryDao {
//
//    @Autowired
//    private SessionFactory factory;
//
//    public MemoryDaoImpl() {
//    }
//
//    @Override
//    public Long create(Memory memory) {
//        Long id = null;
//        id = (Long) factory.getCurrentSession().save(memory);
//        return id;
//
//    }
//
//    @Override
//    public Memory read(Long id) {
//        return (Memory) factory.getCurrentSession().get(Memory.class, id);
//    }
//
//    @Override
//    public boolean update(Memory memory) {
//        factory.getCurrentSession().update(memory);
//        return true;
//    }
//
//    @Override
//    public boolean delete(Memory memory) {
//        factory.getCurrentSession().delete(memory);
//        return true;
//    }
//
//    @Override
//    public List findAll() {
//        return (List) factory.getCurrentSession().createQuery("from Memory").list();}
//}
