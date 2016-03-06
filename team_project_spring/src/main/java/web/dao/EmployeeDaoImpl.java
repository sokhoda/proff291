package web.dao;

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
    public Long create(Employee employee) {
        Session session = factory.getCurrentSession();
        return (Long) session.save(employee);
    }

    @Override
    public Employee read(Long id) {
        Session session = factory.getCurrentSession();
        return (Employee) session.get(Employee.class, id);
    }

    @Override
    public boolean update(Employee employee) {
        Session session = factory.getCurrentSession();
        session.update(employee);
        return true;
    }

    @Override
    public boolean delete(Employee employee) {
        Session session = factory.getCurrentSession();
        session.delete(employee);
        return true;
    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.getCurrentSession();
        return (List<Employee>) session.createQuery("from Employee").list();
        // return session.createCriteria(Employee.class).list();
    }
}
