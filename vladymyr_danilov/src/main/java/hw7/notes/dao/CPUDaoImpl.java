package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class CPUDaoImpl implements CPUDao {
    private SessionFactory factory;

    public CPUDaoImpl() {
    }

    public CPUDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(CPU cpu) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(cpu);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return id;
    }

    @Override
    public CPU read(Long id) {
        Session session = factory.openSession();
        CPU cpu = null;

        try {
            session.beginTransaction();
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
        boolean isUpdate = false;

        try {
            session.beginTransaction();
            session.update(cpu);
            session.getTransaction().commit();
            isUpdate = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isUpdate;

    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = factory.openSession();
        boolean isDelete = false;

        try {
            session.beginTransaction();
            session.delete(cpu);
            session.getTransaction().commit();
            isDelete = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isDelete;
    }

    @Override
    public List<CPU> findAll() {
        Session session = factory.openSession();
        List<CPU> list = new ArrayList<>();

        try {
            session.beginTransaction();
            List query = (List) session.createQuery("from hw7.notes.domain.CPU");
            if ( query != null ) {
                for ( Object object : query ) {
                    list.add((CPU)object);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return list;

    }
}
