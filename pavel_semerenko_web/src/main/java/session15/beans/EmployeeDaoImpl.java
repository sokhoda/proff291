package session15.beans;

import org.hibernate.HibernateError;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import session15.Employee;
import session15.EmployeeDao;

import java.util.List;

/**
 * Created by Pavel on 20.02.2016.
 */
@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    public EmployeeDaoImpl() {
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
    public List<Employee> findAll() {
        Session session = null;
        List<Employee> resultObj = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("FROM Employee");
            resultObj = query.list();
        } catch (HibernateError e){
            if(session != null) {
                session.getTransaction().commit();
            }
            e.printStackTrace();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return resultObj;
    }

    @Override
    public List<Employee> findByDep(Long pedId) {
        return null;
    }

    @Override
    public List<Employee> findEcceptDep(Long depId) {
        return null;
    }
}
