package hw7.springnotes.dao;



import hw7.springnotes.domain.Store;
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
public class StoreDaoImpl implements StoreDao {

    public StoreDaoImpl (){}

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Long create(Store store) {

        Long id = null;
            id = (Long)sessionFactory.getCurrentSession().save(store);
            return id;

    }

    @Override
    public Store read(Long id) {

            return (Store) sessionFactory.getCurrentSession().get(Store.class, id);

    }

    @Override
    public boolean update(Store store) {
        try {
            sessionFactory.getCurrentSession().update(store);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public boolean delete(Store store) {
        try {
            sessionFactory.getCurrentSession().delete(store);
            return true;
        } catch (HibernateException e){
            return false;
        }
    }

    @Override
    public List findAll() {

        Query query = sessionFactory.getCurrentSession().createQuery("from hw7.springnotes.domain.Store");

        return query.list();
    }

    @Override
    public List getNotebooksGtAmount(int amount) {

            Query query = sessionFactory.getCurrentSession().createQuery("select  Notebook as notebook from Store s  where s.quantity > :amount")
            .setParameter("amount", amount);
            return query.list();

    }
}
