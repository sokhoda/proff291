package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
        //return new ArrayList<Employee>(Arrays.asList(new Employee("Petro"), new Employee("Sidor")));
    }

    @Override

    public Employee getEmployeeByFirstName(String firstName) {
        Session session = factory.getCurrentSession();
        try {
            Query query = session.createQuery("from Employees where FIRST_NAME ="+firstName);
            return (Employee) query.uniqueResult();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
