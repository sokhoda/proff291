package hw7.notes.dao;


import hw7.notes.domain.Notebook;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Vendor;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 15.02.2016.
 */
public class SalesDaoImpl implements SalesDao {
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public SalesDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Sales sales) {
        Session session = factory.openSession();
        Long id = null;
        try {
            session.beginTransaction();
            id = (Long) session.save(sales);
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
    public Sales read(Long id) {
        Session session = factory.openSession();
        Sales sales = null;
        try {
            sales = (Sales) session.get(Sales.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sales;
    }

    @Override
    public boolean update(Sales sales) {
        Session session = factory.openSession();
        boolean isUpdated = false;
        try {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            isUpdated = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isUpdated;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = factory.openSession();
        boolean isDeleted = false;
        try {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            isDeleted = true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List findAll() {
        List<Sales> list = new ArrayList<>();
        Session session = factory.openSession();
        try {
            List result = session.createQuery("from Sales").list();
            if (result != null) {
                for (Object vend : result) {
                    list.add((Sales)vend);
                }
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Map getSalesByDays() {
        Map<Sales,Notebook> map = new HashMap<>();
        Session session = factory.openSession();
        Date date = new Date(new java.util.Date().getTime());
        try {
//            List<Object[]> result  = session.createQuery("select s.notebook, sal.amount from Store s join Sales.store sal " +
//                    "where sal.date = :d order by sal.amount  ")
            List<Object[]> result  = session.createQuery("from Sales s join s.store.notebook st where s.date =:d")
                    .setDate("d", date)
                    .list();

            if (result != null) {
                for (Object[] row : result) {
                   map.put((Sales) row[0],(Notebook) row[1]);
                }
            }

            return map;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }
}
//select new map( max(bodyWeight) as max, min(bodyWeight) as min, count(*) as n ) from Cat cat

//    select id, name from Account
//for(Object[] row : rs) {
//        map.put(row[0], row[1]);
//        }