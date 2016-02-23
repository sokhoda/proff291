package hw7.springnotes.dao;

import hw7.springnotes.domain.CPU;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */

@Repository("cpuDao")
public class CPUDaoImpl implements CPUDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public CPUDaoImpl() {}

    public Long create(CPU cpu) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(cpu);
    }

    public CPU read(Long id) {
        Session session = factory.getCurrentSession();
        return (CPU)session.get(CPU.class, id);
    }

    public boolean update(CPU cpu) {
        Session session = factory.getCurrentSession();
        session.update(cpu);
        return true;
    }

    public boolean delete(CPU cpu) {
        Session session = factory.getCurrentSession();
        session.delete(cpu);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<CPU> findAll() {
        Session session = factory.getCurrentSession();
        return (List<CPU>)session.createQuery("from hw7.springnotes.domain.CPU").list();
    }
}
