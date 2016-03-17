package hw7.notes.dao;


import hw7.notes.domain.Memory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public class MemoryDaoImpl implements MemoryDao {
    private SessionFactory factory;

    public MemoryDaoImpl(){};
    public MemoryDaoImpl(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public Long create(Memory memory) {
        Long id=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            id=(Long)session.save(memory);
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
    public Memory read(Long id) {
        Memory aMem=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            aMem =(Memory) session.get(Memory.class,id);
            session.getTransaction().commit();
            return aMem;
        } catch(Exception e){
            session.getTransaction().rollback();
            return aMem;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Memory memory) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(memory);
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
    public boolean delete(Memory memory) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(memory);
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
            Query aQuerry=session.createQuery("from Memory");
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
