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
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Employee employee) {
        return (Long) factory.getCurrentSession().save(employee);
    }

    @Override
    public Employee read(Long id) {
        return (Employee) factory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("from session16.domain.Employee");

        return query.list();
    }
}
