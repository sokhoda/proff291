package hw7.notes.dao;

import hw7.notes.domain.Memory;
import hw7.notes.service.NotebookServiceImpl;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
public class MemoryDaoImpl implements MemoryDao {

    public MemoryDaoImpl(){}

    private SessionFactory sessionFactory;

    @Override
    public Long create(Memory memory) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long)session.save(memory);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            session.getTransaction().rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public Memory read(Long id) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            return (Memory) session.get(Memory.class, id);
        } catch (HibernateException e){
            return null;
        } finally {
            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public boolean update(Memory memory) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(memory);
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
    public List findAll() {
        sessionFactory = NotebookServiceImpl.getSessionFactory();
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from hw7.notes.domain.Memory");
        session.close();
        sessionFactory.close();
        return query.list();
    }
}
