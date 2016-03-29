package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);
    public NotebookDaoImpl(){}
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


    @Override
    public boolean update(Notebook ntb) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ntb);
            session.getTransaction().commit();
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
            session.beginTransaction();
            session.delete(ntb);
            session.getTransaction().commit();
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
    public List findAll() {
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from hw6.notes.domain.Notebook");
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
    public List<Notebook> findByModel(String model) {
        List<Notebook> list = new ArrayList<Notebook>();
        Session session = factory.openSession();
        Query query = null;
        try {
            query = session.createQuery("from Notebook n WHERE n.model = :model");
            query.setParameter("model", model);

            List results = query.list();
            for(Object note : results) {
                list.add((Notebook)note);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public List findByVendor(String vendor) {
        List<Notebook> list = new ArrayList<>();
        Session session = factory.openSession();
        Query query = null;
        try{
            query = session.createQuery("from hw6.notes.domain.Notebook n where n.vendor = :vendor");
            query.setParameter("vendor", vendor);

            List results = query.list();
            for(Object note : results){
                list.add((Notebook)note);
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        List<Notebook> list = new ArrayList<>();
        Session session = factory.openSession();
        Query query = null;
        try{
            query = session.createQuery("from hw6.notes.domain.Notebook n where n.price = :price and n.manufactureDate =  :manufactureDate");
            query.setParameter("price", price);
            query.setParameter("manufactureDate", date);

            List results = query.list();
            for(Object note : results){
                list.add((Notebook)note);
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        List<Notebook> list = new ArrayList<>();
        Session session = factory.openSession();
        Query query = null;
        try{
            query = session.createQuery("from hw6.notes.domain.Notebook as n where n.price > :priceFrom AND n.price <  :priceTo AND "+
                    "n.manufactureDate <= : date AND n.vendor = :vendor ");
            query.setParameter("priceFrom", priceFrom);
            query.setParameter("priceTo", priceTo);
            query.setParameter("date", date);
            query.setParameter("vendor", vendor);

            List results = query.list();
            for(Object note : results){
                list.add((Notebook)note);
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }
}
