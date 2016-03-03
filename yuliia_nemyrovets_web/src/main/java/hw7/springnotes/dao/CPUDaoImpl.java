//package hw7.springnotes.dao;
//
//import hw7.springnotes.dao.CpuDao;
//import hw7.springnotes.domain.Cpu;
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
//public class CpuDaoImpl implements CpuDao {
//
//    @Autowired
//    private SessionFactory factory;
//
//    @Override
//    public Long create(Cpu cpu) {
//        Long id = null;
//        id = (Long) factory.getCurrentSession().save(cpu);
//        return id;
//    }
//
//    @Override
//    public Cpu read(Long id) {
//
//            return (Cpu)  factory.getCurrentSession().get(Cpu.class, id);
//    }
//
//    @Override
//    public boolean update(Cpu cpu) {
//        factory.getCurrentSession().update( cpu);
//        return true;
//
//    }
//
//    @Override
//    public boolean delete(Cpu cpu) {
//        factory.getCurrentSession().delete(cpu);
//        return true;
//    }
//
//    @Override
//    public List findAll() {
//        return (List) factory.getCurrentSession().createQuery("from Cpu").list();
//    }
//}
//
