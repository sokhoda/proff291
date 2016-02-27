package session16.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session16.domain.Employee;

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

    @Override
    public void create(Employee employee) {
        factory.getCurrentSession().save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee read(Long id) {
        return (Employee)factory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void update(Employee employee) {
        factory.getCurrentSession().save(employee);
    }

    @Override
    public void delete(Employee employee) {
        factory.getCurrentSession().save(employee);
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

    @Override
    public Integer getESalary(String name) {
        return null;
    }
}
