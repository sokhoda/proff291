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

    public Long create(Sales sales) {
        Session session = factory.getCurrentSession();
        return (Long)session.save(sales);
    }

    public Sales read(Long id) {
        Session session = factory.getCurrentSession();
        return (Sales)session.get(Sales.class, id);
    }

    public boolean update(Sales sales) {
        Session session = factory.getCurrentSession();
        session.update(sales);
        return true;
    }

    public boolean delete(Sales sales) {
        Session session = factory.getCurrentSession();
        session.delete(sales);
        return true;
    }

    @SuppressWarnings("unchecked")
    public List<Sales> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Sales>)session.createQuery("from hw7.springnotes.domain.Sales").list();
    }

    @SuppressWarnings("unchecked")
    public Map<Date, Integer> findAllByDays() {
        Map<Date, Integer> salesMap;
        Session session = factory.getCurrentSession();

        SQLQuery query = session.createSQLQuery(
                "select trunc(SALE_DATE), sum (AMOUNT) " +
                        "from SALES " +
                        "group by trunc(SALE_DATE)" +
                        "order by trunc(SALE_DATE) desc"
        );
        List<Object[]> results = query.list();
        salesMap = new LinkedHashMap<Date, Integer>();
        for (Object[] obj : results) {
            salesMap.put((Date) obj[0], Integer.parseInt(obj[1].toString()));
        }
        return salesMap;
    }
}
