package web.dao;

import hw7.domain.CPU;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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

    public EmployeeDaoImpl(){
    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.getCurrentSession();
        return session.createCriteria(Employee.class).list();
        //return new ArrayList<Employee>(Arrays.asList(new Employee("Petro"), new Employee("Sidor")));
    }


    @Override
    public Employee findUserByName(String firstName) {
        Session session = factory.getCurrentSession();
        Query query = session.createQuery("FROM web.domain.Employee e WHERE e.firstName =:firstName").setString("firstName", firstName);
        return (Employee) query.uniqueResult();
    }
 /*   @Override
    @Transactional(readOnly = true)
    public Employee findUserByName(String firstName) {
        int id = Integer.parseInt(firstName);
        Session session = factory.getCurrentSession();
        //Query query = session.createQuery("FROM web.domain.Employeee e WHERE e.firstName =:firstName").setString("firstName", firstName);
        return (Employee) session.get(Employee.class, id);
    }*/
}
