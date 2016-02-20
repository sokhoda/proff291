package hw7.notes.dao;

import hw7.notes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory factory;

    public MemoryDaoImpl() {
    }

    public MemoryDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Memory memory) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(memory);
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
    public Memory read(Long id) {
        Session session = factory.openSession();
        Memory memory = null;

        try {
            session.beginTransaction();
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
        boolean isUpdate = false;

        try {
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session = factory.openSession();
        boolean isDelete = false;

        try {
            session.beginTransaction();
            session.delete(memory);
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
    public List<Memory> findAll() {
        Session session = factory.openSession();
        List<Memory> list = new ArrayList<>();

        try {
            session.beginTransaction();
            List query = (List) session.createQuery("from hw7.notes.domain.Memory");
            if ( query != null ) {
                for ( Object object : query ) {
                    list.add((Memory)object);
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
