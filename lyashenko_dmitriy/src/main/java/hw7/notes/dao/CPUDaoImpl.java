package hw7.notes.dao;

import hw7.notes.damain.CPU;

import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Admin on 17.02.2016.
 */
public class CPUDaoImpl implements CPUDao {

    public CPUDaoImpl(){}

    private SessionFactory sessionFactory = NotebookServiceImpl.getSessionFactory();

    @Override
    public Long create(CPU cpu) {
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long)session.save(cpu);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public CPU read(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return (CPU) session.get(CPU.class, id);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public boolean update(CPU cpu) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public java.util.List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from CPU");
        session.close();
        sessionFactory.close();
        return query.list();
    }
}
