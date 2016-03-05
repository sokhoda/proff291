package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
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
public class CPUDaoImpl implements CPUDao {

    public CPUDaoImpl(){}

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(CPU cpu) {

        Long id = null;
        id = (Long)sessionFactory.getCurrentSession().save(cpu);
        return id;

    }

    @Override
    public CPU read(Long id) {
        return (CPU) sessionFactory.getCurrentSession().get(CPU.class, id);


    }

    @Override
    public boolean update(CPU cpu) {
        try {
            sessionFactory.getCurrentSession().update(cpu);
            return true;
        } catch (HibernateException e){
            return false;
        }

    }

    @Override
    public boolean delete(CPU cpu) {
        try {
            sessionFactory.getCurrentSession().delete(cpu);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public List findAll() {
        Query query = sessionFactory.getCurrentSession().createQuery("from hw7.springnotes.domain.CPU");
        return query.list();
    }
}
