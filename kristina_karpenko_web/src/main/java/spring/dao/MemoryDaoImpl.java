package spring.dao;

import spring.domain.Memory;
import spring.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */

@Repository("memoryDao")
public class MemoryDaoImpl implements MemoryDao {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public MemoryDaoImpl() {
    }

    public MemoryDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Long create(Memory memory) {
        return (Long) getSession().save(memory);
    }

    @Override
    public Memory read(Long id) {
        return (Memory) getSession().get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        getSession().update(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        getSession().delete(memory);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Memory>) getSession().createQuery("from Memory m").list();
    }

    @Override
    public Memory findMemoryByName(String nameVend, String size) {
        VendorDao vendorDao = new VendorDaoImpl(factory);
        Vendor vendor = vendorDao.findVendorByName(nameVend);
        return (Memory) getSession().createQuery("from Memory m where m.vendor = :vendor and m.size = :size ")
                .setParameter("vendor", vendor)
                .setString("size", size);

    }
}
