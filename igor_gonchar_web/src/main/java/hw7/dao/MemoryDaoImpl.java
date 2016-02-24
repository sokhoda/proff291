package hw7.dao;

import hw7.domain.Memory;
import hw7.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@Repository("memoryDao")
public class MemoryDaoImpl implements MemoryDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(memory);
        return id;
    }

    @Override
    public Memory read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (Memory) session.get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        Session session = mySessionFactory.getCurrentSession();
        boolean isUpdated = false;
        session.update(memory);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = mySessionFactory.getCurrentSession();
        boolean isDeleted = false;
        session.delete(memory);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw7.domain.Memory m");
        return query.list();
    }
}
