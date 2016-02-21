package hw7.springnotes.dao;

import hw7.springnotes.domain.Sales;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Вадим on 14.02.2016.
 */

@Repository("salesDao")
public class SalesDaoImpl implements SalesDao {

    @Autowired(required = true)
    private SessionFactory factory;

    public SalesDaoImpl() {}

    @Override
    public Long create(Sales sales) {
        Session session = factory.openSession();
        Long id = null;
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            id = (Long)session.save(sales);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
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
            sales = (Sales)session.get(Sales.class, id);
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
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(sales);
            tx.commit();
            isUpdated = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
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
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(sales);
            tx.commit();
            isDeleted = true;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return isDeleted;
    }

    @Override
    public List<Sales> findAll() {
        Session session = factory.openSession();
        try {
            return (List<Sales>)session.createQuery("from hw7.springnotes.domain.Sales").list();
        } finally {
            session.close();
        }
    }

    public Map<Date, Integer> findAllByDays() {
        Map<Date, Integer> salesMap;
        Session session = factory.openSession();
        try {
            SQLQuery query = session.createSQLQuery(
                    "select trunc(SALE_DATE), sum (AMOUNT) " +
                            "from SALES " +
                            "group by trunc(SALE_DATE)"
            );
            List<Object[]> results = query.list();
            salesMap = new HashMap<Date, Integer>();
            for (Object[] obj : results) {
                salesMap.put((Date) obj[0], Integer.parseInt(obj[1].toString()));
            }
        } finally {
            session.close();
        }
        return salesMap;
    }
}
