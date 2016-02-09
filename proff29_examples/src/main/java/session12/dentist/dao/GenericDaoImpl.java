package session12.dentist.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;


/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 8/18/13
 */
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {

        this.type = type;
    }

    @Override
    public PK create(T o) {
        return (PK) getSessionFactory().openSession().save(o);
    }

    public T get(PK id) {
        return (T) getSessionFactory().openSession().get(type, id);
    }

    public List<T> getAll() {
        Criteria crit = getSessionFactory().openSession().createCriteria(type);
        return crit.list();
    }

    @Override
    public void update(T o) {
        getSessionFactory().openSession().update(o);
    }

    @Override
    public void createOrUpdate(T persistentObject) {

    }

    @Override
    public void delete(T persistentObject) {

    }

    private static SessionFactory getSessionFactory() {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session11/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
}