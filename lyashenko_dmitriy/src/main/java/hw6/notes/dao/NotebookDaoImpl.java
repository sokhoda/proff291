package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Solyk on 08.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    public static Logger logger = Logger.getLogger(NotebookDaoImpl.class);
    private SessionFactory sessionFactory = getSessionFactory();

    public NotebookDaoImpl(){

    }



    private SessionFactory getSessionFactory() {

        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("hw6.notes.resources/NotebookHiberDao.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();

        return cfg.buildSessionFactory(standardServiceRegistry);
    }
    @Override
    public Long create(Notebook ntb) {
        Long id = null;
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e){
            logger.error("Connection False");
            session.getTransaction().rollback();
            return null;
        } finally {

            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public Notebook read(Long id) {
        Session session = sessionFactory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e){
            logger.error("Connection False");
            return null;
        } finally {

            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public boolean update(Notebook ntb) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            logger.error("Connection False");
            return false;
        }finally {

            session.close();
            sessionFactory.close();
        }

    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e){
            logger.error("Connection False");
            return false;
        }finally {

            session.close();
            sessionFactory.close();
        }
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook");
        session.close();
        sessionFactory.close();
        return query.list();

    }

    @Override
    public List findByModel(String model) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook n where n.model like " + "'" + model + "'");
        session.close();
        sessionFactory.close();
        return query.list();
    }

    @Override
    public List findByVendor(String vendor) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook n where n.vendor like " + "'" + vendor + "'");
        session.close();
        sessionFactory.close();
        return query.list();

    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook n where n.price like " + price + " and n.manufactureDate like " + date);
        session.close();
        sessionFactory.close();
        return query.list();

    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Notebook n where n.price > " + priceFrom + " and n.price <  " + priceTo + " and n.manufactureDate < " + date +
                " and n.vendor < " + "'" + vendor + "'" );
        session.close();
        sessionFactory.close();
        return query.list();
    }


}
