package hw7.springnotes.dao;

import hw7.springnotes.domain.Memory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */

@Repository("memoryDao")
public class MemoryDaoImpl implements MemoryDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public MemoryDaoImpl() {}

    public Long create(Memory memory) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(memory);
    }

    public Memory read(Long id) {
        Session session = factory.getCurrentSession();
        return (Memory)session.get(Memory.class, id);
    }

    public boolean update(Memory memory) {
        Session session = factory.getCurrentSession();
        session.update(memory);
        return true;
    }

    public boolean delete(Memory memory) {
        Session session = factory.getCurrentSession();
        session.delete(memory);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<Memory> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Memory>)session.createQuery("from hw7.springnotes.domain.Memory").list();
    }
}
