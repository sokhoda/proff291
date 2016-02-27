package session15.domain.session15.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import web.domain.*;
import web.domain.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Юлия on 20.02.2016.
 */
public class EmployeeDaoIml implements EmployeeDao{

    private static Logger log = Logger.getLogger(EmployeeDaoIml.class);
    private SessionFactory factory;

    public EmployeeDaoIml(SessionFactory factory) {
        this.factory = factory;

    }

    @Override
    public List findAllEmployee() {
       // List<Employee> list = new ArrayList<>();

        Session session = factory.openSession();
        try {
           Query query = session.createQuery("from Employee");
           // List<Object[]> list1 = query.list();

            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List findAllEmployeeByDepartment(Integer dep_id) {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Employee e join e.department where e.department=:DEP");
            query.setParameter("DEP", dep_id);
            System.out.println(dep_id);
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();

        }
    }

    @Override
    public List findAllEmployeeWithNoDepartment() {
        Session session = factory.openSession();
        session.beginTransaction();
        try {
            Query query = session.createQuery("from Employee e join e.department where e.department is null");

            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();

        }
    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        EmployeeDaoIml.log = log;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

}
