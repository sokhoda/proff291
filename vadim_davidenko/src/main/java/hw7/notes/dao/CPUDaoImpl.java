package hw7.notes.dao;

import hw7.notes.domain.CPU;
import hw7.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */
public class CPUDaoImpl implements CPUDao {

    private SessionFactory factory;

    public CPUDaoImpl() {}

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Long)session.save(cpu);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
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
            cpu = (CPU)session.get(CPU.class, id);
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
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(cpu);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
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
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(cpu);
            tx.commit();
            isDeleted = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List<CPU> findAll() {
        Session session = factory.openSession();
        try {
            return (List<CPU>)session.createQuery("from hw7.notes.domain.CPU").list();
        } finally {
            session.close();
        }
    }
}
