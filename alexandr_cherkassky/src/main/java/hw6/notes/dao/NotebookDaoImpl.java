package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Пк2 on 09.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {

    private SessionFactory factory= null;
    private String newField;


    public NotebookDaoImpl(){}

    public NotebookDaoImpl(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session currSession=factory.openSession();
        Long id=null;
        try{
            currSession.beginTransaction();
            id=(Long)currSession.save(ntb);
            currSession.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            currSession.getTransaction().rollback();
        }
        finally {
            currSession.close();
        }
        return id;
    }

    @Override
    public Notebook read(Long id) {
        Session currSession=factory.openSession();
        Notebook aNotebook=null;
        try{
            currSession.beginTransaction();
            aNotebook=(Notebook)currSession.get(Notebook.class,id);
        } catch(Exception e){
            e.printStackTrace();
            currSession.getTransaction().rollback();
        }
        finally{
            currSession.close();
        }
        return aNotebook;
    }

    @Override
    public boolean update(Notebook ntb) {
        Session currSession=factory.openSession();
        try{
            currSession.beginTransaction();
            currSession.update(ntb);//?????????
            currSession.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            currSession.getTransaction().rollback();
        } finally{
            currSession.close();
        }
        return false;
    }

    @Override
    public boolean delete(Notebook ntb) {
        if (ntb == null) {
            return false;
        }
        Session currSession = factory.openSession();
        try{
            currSession.beginTransaction();
            currSession.delete(ntb);
            currSession.getTransaction().commit();
            return true;

        } catch(Exception e){
            currSession.getTransaction().rollback();
            return false;
        }
        finally{
            currSession.close();
        }
    }

    @Override
    public List findAll() {
        Session currSession=factory.openSession();
        try {
            String queryStr="from Notebook";
            Query currQuery = currSession.createQuery(queryStr);
            return currQuery.list();
        } catch(Exception e){
               e.printStackTrace();
               return null;
        } finally{
            currSession.close();
        }

    }

    @Override
    public List findByModel(String model) {
        Session session=factory.openSession();
        try{
            Query query=session.createQuery("from Notebook where model=:Model");
            query.setParameter("Model",model);
            return query.list();
        } catch( Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally{
            session.close();
        }
    }

    @Override
    public List findByVendor(String vendor) {
        Session session=factory.openSession();
        try{
            Query query=session.createQuery("from Notebook where vendor=:Vendor");
            query.setParameter("Vendor",vendor);
            return query.list();
        } catch( Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally{
            session.close();
        }
    }

    @Override
    public List findByPriceManufDate(Double price, Date date) {
        Session session=factory.openSession();
        try{
            Query query=session.createQuery("from Notebook where price=:Price and manufDate=:Date");
            query.setParameter("Price",price);
            query.setParameter("Date",date);
            return query.list();
        } catch( Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally{
            session.close();
        }
    }

    @Override
    public List findBetweenPriceLtDateByVendor(Double priceFrom, Double priceTo, Date date, String vendor) {
        Session session=factory.openSession();
        try{
            Query query=session.createQuery("from Notebook where price>=:PriceFrom and price<=:PriceTo and manufDate<=:Date and vendor=:Vendor ");
            query.setParameter("PriceFrom",priceFrom);
            query.setParameter("PriceTo",priceTo);
            query.setParameter("Date",date);
            query.setParameter("Vendor",vendor);
            return query.list();
        } catch( Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        } finally{
            session.close();
        }
    }
}
