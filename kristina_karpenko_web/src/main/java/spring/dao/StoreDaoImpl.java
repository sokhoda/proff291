package spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.domain.Store;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 15.02.2016.
 */
@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public StoreDaoImpl() {
    }

    public StoreDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Long create(Store store) {
        return (Long) getSession().save(store);
    }

    @Override
    public Store read(Long id) {
        return (Store) getSession().get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        getSession().update(store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        getSession().delete(store);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Store>) getSession().createQuery("from Store s").list();
    }


}
