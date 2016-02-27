package laptopshop.dao;

import laptopshop.domain.CPU;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
@Repository
public class CPUDaoImpl implements CPUDao {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public CPUDaoImpl() {
    }

    @Override
    public Long create(CPU cpu) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(cpu);
    }

    @Override
    public CPU read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (CPU) session.get(CPU.class, id);
    }

    @Override
    public boolean update(CPU cpu) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.update(cpu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(CPU cpu) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.delete(cpu);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<CPU> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<CPU>) session.createQuery("FROM CPU").list();
    }
}
