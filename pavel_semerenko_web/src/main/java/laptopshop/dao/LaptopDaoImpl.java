package laptopshop.dao;

import laptopshop.domain.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
@Repository
public class LaptopDaoImpl implements LaptopDao {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public LaptopDaoImpl() {
    }

    @Override
    public Long create(Laptop laptop) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(laptop);
    }

    @Override
    public Laptop read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Laptop) session.get(Laptop.class, id);
    }

    @Override
    public boolean update(Laptop laptop) {
        Session session = sessionFactory.getCurrentSession();
        session.update(laptop);
        return true;
    }

    @Override
    public boolean delete(Laptop laptop) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(laptop);
        return true;
    }

    @Override
    public List<Laptop> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Laptop>) session.createQuery("FROM Laptop").list();
    }
}
