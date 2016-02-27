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
 * Created by Юлия on 22.02.2016.
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired(required = true)
    private SessionFactory factory;

    public EmployeeDaoImpl() {

    }

    @Override
    public List findAllEmployee() {
        Session session = factory.getCurrentSession();
        try {
            String name = "";
            Query query = session.createQuery(" from Employee");
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public List findName(String name) {
        Session session = factory.getCurrentSession();
        try {
            Query query = session.createQuery(" from Employee e where e.name=:name ");
           query.setParameter("name", name);
            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();

        }
    }

    @Override
    public Long create(Employee employee) {
        return null;
    }

    @Override
    public Employee read(Long id) {
        return null;
    }

    @Override
    public void update(Employee employee) {

    }
}