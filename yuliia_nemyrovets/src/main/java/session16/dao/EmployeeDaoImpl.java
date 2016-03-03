package session16.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import session16.domain.Employee;


import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    public EmployeeDaoImpl() {

    }

    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;



    @Override
    public List findAllEmployee() {
//        Session session = factory.getCurrentSession();
//        try {
//            String name = "";
//            Query query = session.createQuery("select firstName from Employee");
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//
//        }
        return null;
    }

    @Override
    public List findName(String firstName) {
//        Session session = factory.getCurrentSession();
//        try {
//            Query query = session.createQuery("select e.firstName from Employee e where e.name=:name ");
//           query.setParameter("name", name);
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//
//        }
        return(List)factory.getCurrentSession().createQuery(" from Employee e where e. firstName=:name ").setParameter("name",firstName).list();
    }

    @Override
    public Long create(Employee employee) {
        return null;
    }

    @Override
    public Employee read(Long id) {
        return (Employee) factory.getCurrentSession().get(Employee.class, id);

    }

    @Override
    public void update(Employee employee) {

    }
}