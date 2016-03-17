package hw7.notes.dao;

import hw7.notes.domain.CPU;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Пк2 on 17.03.2016.
 */
public class CPUDaoImpl implements CPUDao {
    private SessionFactory factory=null;
    public CPUDaoImpl(){};
    public CPUDaoImpl(SessionFactory factory){
        this.factory=factory;
    }

    @Override
    public Long create(CPU cpu) {
        Long id=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            id=(Long)session.save(cpu);
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
    public CPU read(Long id) {
        CPU aCPU=null;
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            aCPU =(CPU)session.get(CPU.class,id);
            session.getTransaction().commit();
            return aCPU;
        } catch(Exception e){
            session.getTransaction().rollback();
            return aCPU;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(CPU cpu) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(cpu);
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
    public boolean delete(CPU cpu) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(cpu);
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
            Query aQuerry=session.createQuery("from CPU");
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
