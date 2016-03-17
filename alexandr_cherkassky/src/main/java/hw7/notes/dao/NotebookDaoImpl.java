package hw7.notes.dao;


import hw7.notes.domain.Notebook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public class NotebookDaoImpl implements NotebookDao {
    private SessionFactory factory;

    public NotebookDaoImpl(){};
    public NotebookDaoImpl(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public Long create(Notebook notebook) {
        Long id=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            id=(Long)session.save(notebook);
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
    public Notebook read(Long id) {
       Notebook aNtb=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            aNtb =(Notebook) session.get(Notebook.class,id);
            session.getTransaction().commit();
            return aNtb;
        } catch(Exception e){
            session.getTransaction().rollback();
            return aNtb;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Notebook notebook) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(notebook);
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
    public boolean delete(Notebook notebook) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(notebook);
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
            Query aQuerry=session.createQuery("from Notebook");
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
