package hw7.springnotes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by v.davidenko on 22.02.2016.
 */

@Repository
public class GeneralDaoImpl implements GeneralDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public <T> void freeObject(Object o) {
        getSession().evict(o);
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public <T> Collection<T> getAll(Class<T> clazz) {
        return (Collection<T>)getSession().createQuery("from "+ clazz.getSimpleName()).list();
    }

    @Override
    public <T> T getObject(Class<T> clazz, Long id) {
        return (T) getSession().get(clazz, id);
    }

    @Override
    public void saveOrUpdate(Object object) throws DataIntegrityViolationException {
        getSession().saveOrUpdate(object);
    }
    @Override
    public void update(Object object) throws DataIntegrityViolationException {
        getSession().update(object);
    }

    @Override
    public void insert(Object object) throws DataIntegrityViolationException {
        getSession().save(object);
        getSession().flush();
    }

    @Override
    public void flush() throws DataIntegrityViolationException {
        getSession().flush();
        getSession().clear();
    }

    @Override
    public void persist(Object object) throws DataIntegrityViolationException {
        getSession().persist(object);
    }


    @Override
    public <T> void deleteObject(Class<T> clazz, Long objectId) {
        getSession().delete(getObject(clazz, objectId));
    }


    @Override
    public void deleteObject(Object o) {
        getSession().delete(o);
    }
}
