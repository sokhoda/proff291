package hw7.springnotes.dao;


import hw7.springnotes.domain.Memory;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Admin on 17.02.2016.
 */
@Repository
public class MemoryDaoImpl implements MemoryDao {

    public MemoryDaoImpl(){}

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Memory memory) {
        Long id = null;
        id = (Long)sessionFactory.getCurrentSession().save(memory);
        return id;

    }

    @Override
    public Memory read(Long id) {
        return (Memory) sessionFactory.getCurrentSession().get(Memory.class, id);

    }

    @Override
    public boolean update(Memory memory) {

        try {
            sessionFactory.getCurrentSession().update(memory);
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public boolean delete(Memory memory) {
            try {
                sessionFactory.getCurrentSession().delete(memory);
                return true;
            } catch (HibernateException e) {
                return false;
            }
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from hw7.springnotes.domain.Memory");
        return query.list();
    }
}
