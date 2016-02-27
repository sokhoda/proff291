package hw7.dao;

import hw7.domain.CPU;
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
@Repository("cpuDao")
public class CPUDaoImpl implements CPUDao {
    private static Logger log = Logger.getLogger(VendorDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    public CPUDaoImpl() {
    }

    @Override
    public Long create(CPU cpu) {
        Session session = mySessionFactory.getCurrentSession();
        Long id = (Long) session.save(cpu);
        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = mySessionFactory.getCurrentSession();
        return (CPU) session.get(CPU.class, id);
    }

    @Override
    public boolean update(CPU cpu) {
        boolean isUpdated = false;
        Session session = mySessionFactory.getCurrentSession();
        session.update(cpu);
        isUpdated = true;
        return isUpdated;
    }

    @Override
    public boolean delete(CPU cpu) {
        boolean isDeleted = false;
        Session session = mySessionFactory.getCurrentSession();
        session.delete(cpu);
        isDeleted = true;
        return isDeleted;
    }

    @Override
    public List findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM hw7.domain.CPU c");
        return query.list();
    }
}
