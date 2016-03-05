package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class SalesDaoImpl implements SalesDao {
    private SessionFactory factory;

    public SalesDaoImpl() {
    }

    public SalesDaoImpl(SessionFactory factory) {

        this.factory = factory;
    }

    @Override
    public Long create(Sales sales) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(sales);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return id;
    }

    @Override
    public Sales read(Long id) {
        Session session = factory.openSession();
        Sales sales = null;

        try {
            session.beginTransaction();
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
        boolean isUpdate = false;

        try {
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            isUpdate = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isUpdate;
    }

    @Override
    public boolean delete(Sales sales) {
        Session session = factory.openSession();
        boolean isDelete = false;

        try {
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            isDelete = true;
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return isDelete;
    }

    @Override
    public List<Sales> findAll() {
        Session session = factory.openSession();
        List<Sales> list = new ArrayList<>();

        try {
            session.beginTransaction();
            List query = (List) session.createQuery("from hw7.notes.domain.Sales");
            if ( query != null ) {
                for ( Object object : query ) {
                    list.add((Sales) object);
                }
            }
            session.getTransaction().commit();
        } catch (HibernateException e) {
            if ( session != null ) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if ( session != null ) {
                session.close();
            }
        }

        return list;
    }
}
