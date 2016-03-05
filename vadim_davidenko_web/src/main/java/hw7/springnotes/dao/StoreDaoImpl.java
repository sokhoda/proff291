package hw7.springnotes.dao;

import hw7.springnotes.domain.Store;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 14.02.2016.
 */

@Repository("storeDao")
public class StoreDaoImpl implements StoreDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public StoreDaoImpl() {}

    public Long create(Store store) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(store);
    }

    public Store read(Long id) {
        Session session = factory.getCurrentSession();
        return (Store)session.get(Store.class, id);
    }

    public boolean update(Store store) {
        Session session = factory.getCurrentSession();
        session.update(store);
        return true;
    }

    public boolean delete(Store store) {
        Session session = factory.getCurrentSession();
        session.delete(store);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<Store> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Store>)session.createQuery("from hw7.springnotes.domain.Store").list();
    }

    @SuppressWarnings("unchecked")
    public List<Store> findOnStorePresent() {
        Session session = factory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(
                "select * from NOTEBOOK n, STORE s " +
                        "where n.NOTEBOOK_ID = s.NOTEBOOK_ID" +
                        "and s.AMOUNT > 0"
        );
        query.addEntity(Store.class);
        return query.list();
    }
}
