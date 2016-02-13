package hw6.notes.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by Пк2 on 09.02.2016.
 */
public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory= null;

    public NotebookDaoImpl(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public Long create(Notebook ntb) {
        Session currSession=factory.openSession();
        Transaction tr;
        Long id=null;
        try{
            currSession.beginTransaction();
            id=(Long)currSession.save(ntb);
            currSession.getTransaction().commit();
        } catch(Exception e){

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
            currSession.getTransaction().rollback();
        }
        finally{
            currSession.close();
        }
        return aNotebook;
    }

    @Override
    public boolean update(Notebook ntb) {

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
            Query currQuery = currSession.createQuery("from Notebook");
            return currQuery.list();
        } catch(Exception e){

        } finally{
            currSession.close();
        }

    }
}
