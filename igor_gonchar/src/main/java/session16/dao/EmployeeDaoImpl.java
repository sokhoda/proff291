package session16.dao;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session16.domain.Employee;

import java.util.List;

/**
 * Created by Home on 20.02.2016.
 */
@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory mySessionFactory;

    @Override
    public List<Integer> getEmployeeSalaryByName(String firstName) {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e.salary FROM Employee e WHERE e.firstName =:firstName").setString("firstName", firstName);
        System.out.println(query.toString());
        List<Integer> salary = query.list();

        return salary;
    }

    public EmployeeDaoImpl() {
    }

    @Override
    public Integer create(Employee employee) {
        Session session = mySessionFactory.getCurrentSession();
        Integer id = (Integer) session.save(employee);
        return id;
    }

    @Override
    public void read(Long id) {

    }

    @Override
    public boolean delete(Employee employee) {
        Session session = mySessionFactory.getCurrentSession();
        session.delete(employee);
        return true;
    }

    @Override
    public List<Employee> findAll() {
        Session session = mySessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Employee e");
        return query.list();

    }

    @Override
    public List<Employee> findByDep(Long depId) {
        return null;
    }

    @Override
    public List<Employee> findEcceptDep(Long depId) {
        return null;
    }
}
