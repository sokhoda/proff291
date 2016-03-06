package spring.dao;


import spring.domain.CPU;
import spring.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
@Repository("cpuDao")
public class CPUDaoImpl implements CPUDao {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public CPUDaoImpl() {
    }

    public CPUDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.getCurrentSession();
        return (Long) session.save(cpu);
    }

    @Override
    public CPU read(Long id) {
        Session session = factory.getCurrentSession();
        return (CPU) session.get(CPU.class, id);
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.getCurrentSession();
        session.update(cpu);
        return true;
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.getCurrentSession();
        session.delete(cpu);
        return true;
    }

    @Override
    public List findAll() {
        Session session = factory.getCurrentSession();
        return (List<CPU>) session.createQuery("from CPU c").list();
    }

    @Override
    public List findCPUbyVendor(Vendor vendor) {
        List<CPU> list = new ArrayList<>();
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from CPU u where u.vendor = :vendor ");
            query.setParameter("vendor", vendor);
            List result = query.list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((CPU) vend);
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
    public CPU findCPUByName(String name) {
        Session session = factory.openSession();
        Query query;
        CPU cpu = null;
        try {
            List<CPU> cpus = session.createQuery("from CPU v where v.model = :n ").setString("n", name).list();

            for (CPU c : cpus) {
                cpu = c;
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cpu;
    }

}