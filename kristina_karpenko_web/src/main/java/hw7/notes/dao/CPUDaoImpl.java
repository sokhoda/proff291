package hw7.notes.dao;


import hw7.notes.domain.CPU;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
public class CPUDaoImpl implements CPUDao {

    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public CPUDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(cpu);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = factory.openSession();
        CPU cpu = null;
        try {
            cpu = (CPU) session.get(CPU.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cpu;
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        try {
            session.beginTransaction();
            session.delete(cpu);
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
        List<CPU> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("from hw7.notes.domain.CPU").list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((CPU)vend);
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
    public List findCPUbyVendor(Vendor vendor) {
        List<CPU> list = new ArrayList<>();
        Session session = factory.openSession();
        Query query = null;
        try {
            query= session.createQuery("from hw7.notes.domain.CPU u where u.vendor = :vendor ");
            query.setParameter("vendor", vendor);
            List result = query.list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((CPU)vend);
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
