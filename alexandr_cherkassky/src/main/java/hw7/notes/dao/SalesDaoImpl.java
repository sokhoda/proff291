package hw7.notes.dao;

import hw7.notes.domain.Sales;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public class SalesDaoImpl implements SalesDao {
    private SessionFactory factory;

    public SalesDaoImpl(){};
    public SalesDaoImpl(SessionFactory factory){
        this.factory=factory;
    };
    @Override
    public Long create(Sales sales) {
        Long id=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            id=(Long)session.save(sales);
            session.getTransaction().commit();
            return id;
        } catch(Exception e){
            session.getTransaction().rollback();
            return id;
        } finally {
            session.close();
        }
    }

    @Override
    public Sales read(Long ig) {
        Sales aSales=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            aSales =(Sales) session.get(Sales.class,ig);
            session.getTransaction().commit();
            return aSales;
        } catch(Exception e){
            session.getTransaction().rollback();
            return aSales;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Sales sales) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(sales);
            session.getTransaction().commit();
            return true;
        } catch(Exception e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Sales sales) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(sales);
            session.getTransaction().commit();
            return true;
        } catch(Exception e){
            session.getTransaction().rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List findAll() {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            Query aQuerry=session.createQuery("from Sales");
            session.getTransaction().commit();
            return aQuerry.list();
        } catch(Exception e){
            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
