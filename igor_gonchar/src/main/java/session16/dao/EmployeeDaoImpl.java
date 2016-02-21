package session16.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session16.domain.Employee;

import java.util.List;

/**
 * Created by Home on 20.02.2016.
 */
@Repository("empDao")
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory sf;

    @Override
    @Transactional(readOnly = true)
    public int getEmployeeSalaryByName(String name) {
        Session session = sf.openSession();
        Query query = session.createQuery("SELECT e.salary FROM Employee e WHERE e.firstName =:name");
        query.setString("name",name);
        String salaryS = query.toString();
        return Integer.parseInt(salaryS);
    }

    public EmployeeDaoImpl(){
    }

    @Override
    public Long create(Employee employee) {
        return null;
    }

    @Override
    public void read(Long id) {

    }

    @Override
    public void delete(Employee id) {

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        Session session = sf.openSession();
        Query query = session.createQuery("FROM Employee e");
        return query.list();

    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findByDep(Long depId) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findEcceptDep(Long depId) {
        return null;
    }
}
