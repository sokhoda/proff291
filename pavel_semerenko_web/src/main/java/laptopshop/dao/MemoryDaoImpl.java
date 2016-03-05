package laptopshop.dao;

import laptopshop.domain.Memory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
@Repository
public class MemoryDaoImpl implements MemoryDao {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public MemoryDaoImpl() {
    }

    @Override
    public Long create(Memory memory) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(memory);
    }

    @Override
    public Memory read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Memory) session.get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        Session session = sessionFactory.getCurrentSession();
        session.update(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(memory);
        return true;
    }

    @Override
    public List<Memory> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Memory>) session.createQuery("FROM laptopshop.domain.Memory").list();
    }
}
