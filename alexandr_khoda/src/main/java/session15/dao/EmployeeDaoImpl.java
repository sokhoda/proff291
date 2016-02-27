package session15.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by s_okhoda on 20.02.2016.
 */

@Repository("emplDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

    public EmployeeDaoImpl() {
    }

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List findAll() {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from Employee");
//            query.setParameter("compID", id);
            return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
//            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List findAllDept(Long id) {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from Employee e join e.department d where d.id = :DEPT");
            query.setParameter("DEPT", id);
            return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
//            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List findAllUnemployed() {
        Session session = factory.openSession();
        try{
            Query query = session.createQuery("from Employee e where e.department = null");
            return query.list();
        } catch (HibernateException e) {
            log.error("Transaction failed", e);
//            session.getTransaction().rollback();
            return null;
        } finally {
            session.close();
        }
    }
}
