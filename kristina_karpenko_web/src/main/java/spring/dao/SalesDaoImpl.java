package spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import spring.domain.Notebook;
import spring.domain.Sales;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Администратор on 15.02.2016.
 */
@Repository("salesDao")
public class SalesDaoImpl implements SalesDao {
    @Autowired(required = true)
    private SessionFactory factory;
    private static Logger log = Logger.getLogger(NotebookDaoImpl.class);

    public SalesDaoImpl() {
    }

    public SalesDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    private Session getSession() {
        return factory.getCurrentSession();
    }

    @Override
    public Long create(Sales sales) {
        return (Long) getSession().save(sales);
    }

    @Override
    public Sales read(Long id) {
        return (Sales) getSession().get(Sales.class, id);
    }

    @Override
    public boolean update(Sales sales) {
        getSession().update(sales);
        return true;
    }

    @Override
    public boolean delete(Sales sales) {
        getSession().delete(sales);
        return true;
    }

    @Override
    public List findAll() {
        return (List<Sales>) getSession().createQuery("from Sales").list();

    }

    @Override
    public Map getSalesByDays() {
        //            if (result != null) {
//                for (Object[] row : result) {
//                    map.put((Sales) row[0], (Notebook) row[1]);
//                }
//            }

        return (Map<Sales, Notebook>) getSession().createQuery("from Sales s join s.store.notebook st where s.date =:d")
                .setDate("d", new Date(new java.util.Date().getTime()))
                .list();
    }


}
