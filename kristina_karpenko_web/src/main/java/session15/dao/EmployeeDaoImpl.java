package session15.dao;


import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session15.domain.Employee;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 20.02.2016.
 */
public class EmployeeDaoImpl implements EmployeeDao{

    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
       private SessionFactory factory;

    public EmployeeDaoImpl(){}

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;

    }

    @Override
    public Long create(Employee employee) {
        Session session = factory.openSession();
        Long id = null;

        try {
            session.beginTransaction();
            id = (Long) session.save(employee);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return id;
    }


    @Override
    public Employee findAllEmployee() {
        //   List<Employee> list = new ArrayList<>();
        Employee employee = null;
        Session session = factory.openSession();
        try {
            return (Employee)session.createQuery("from Employee e where e.firstName = 'Kris' ").uniqueResult();
//            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List findAllEmployeeByDepartment(int dep_id) {
        Session session = factory.openSession();
        List<Employee> list = new ArrayList<>();
        try {
            List result= session.createQuery("from Employee e join e.department d WHERE d.id =:depId ").setParameter("depId", dep_id).list();

            for (Object vend : result) {
                list.add((Employee)vend);
            }
            return list;
        } catch (HibernateException e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();

        }
        //    return list;
    }

    @Override
    public List findAllEmployeeWithNoDepartment() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("FROM Employee WHERE DEPARTMENT_ID IS NULL ");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();

        }
    }



}
