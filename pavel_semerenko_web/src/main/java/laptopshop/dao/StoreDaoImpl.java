package laptopshop.dao;

import laptopshop.domain.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Pavel on 18.02.2016.
 */
@Repository
public class StoreDaoImpl implements StoreDao {

    @Autowired(required = true)
    SessionFactory sessionFactory;

    public StoreDaoImpl() {
    }

    @Override
    public Long create(Store store) {
        Session session = sessionFactory.getCurrentSession();
        return (Long) session.save(store);
    }

    @Override
    public Store read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Store) session.get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        Session session = sessionFactory.getCurrentSession();
        session.update(store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        Session session = sessionFactory.getCurrentSession();
        session.update(store);
        return true;
    }

    @Override
    public List<Store> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return (List<Store>) session.createQuery("FROM Store").list();
    }
}
