package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public NotebookDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(ntb);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session session = factory.openSession();
        try {
            return (Notebook) session.get(Notebook.class, id);
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    /////////////
    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("from hw6.notes.domain.Notebook n where n.id = :ntb.id ");
            return true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.delete(ntb);
            return  true;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        Query query = null;
        try {

            query = session.createQuery("select n from hw6.notes.domain.Notebook n");

            List<Object[]> list = query.list();
            System.out.println(Arrays.toString(list.get(0)));
            System.out.println(Arrays.toString(list.get(1)));
            List count;
            for (int i = 0; (count = query.list()).size() != 0; i = +5) {
                query.setFirstResult(i);
                query.setMaxResults(5);
                System.out.println(count);
            }

        } catch (HibernateException e) {
            log.error("Open session failed", e);
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
            factory.close();
        }
        log.info(session);
        return query.list();
    }

    @Override
    public List findByModel(String model) {
        return null;
    }

    @Override
    public List findByVendor(String vendor) {
        return null;
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        return null;
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        return null;
    }
}
