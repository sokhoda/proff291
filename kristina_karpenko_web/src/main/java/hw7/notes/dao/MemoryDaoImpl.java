package hw7.notes.dao;


import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */public class MemoryDaoImpl implements MemoryDao {

    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    public MemoryDaoImpl(){}
    public MemoryDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }
    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long)session.save(memory);
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
    public Memory read(Long id) {
        Session session = factory.openSession();
        Memory memory = null;
        try {
            memory = (Memory) session.get(Memory.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return memory;
    }

    @Override
    public boolean update(Memory memory) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        try {
            session.beginTransaction();
            session.delete(memory);
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
        List<Memory> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("from hw7.notes.domain.Memory").list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((Memory)vend);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }
    @Override
    public Memory findMemoryByName(String nameVend, String size) {
        Session session = factory.openSession();
        Memory memory = null;
        VendorDao vendorDao = new VendorDaoImpl(factory);
        Vendor vendor;
        try {
            vendor = vendorDao.findVendorByName(nameVend);

            List<Memory> mem = session.createQuery("from Memory m where m.vendor = :vendor and m.size = :size " )
                    .setParameter("vendor", vendor)
                    .setString("size", size)
                    .list();
            for (Memory m : mem) {
                memory = m;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return memory;
    }
}
