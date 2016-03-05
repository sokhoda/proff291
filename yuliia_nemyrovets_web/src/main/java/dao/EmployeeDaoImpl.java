package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.domain.Employee;

import java.util.List;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory factory;

    public EmployeeDaoImpl() {

    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
        //return new ArrayList<Employee>(Arrays.asList(new Employee("Petro"), new Employee("Sidor")));
    }

    @Override
    public Employee findEmployeeByName(String firstName) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery(" from Employee e where e.firstName=:name");
        query.setParameter("name", firstName);
        return (Employee) query.uniqueResult();

    }
}
