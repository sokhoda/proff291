package session16;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Solyk on 20.02.2016.
 */

@Component("empD")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private SessionFactory sf;

    public EmployeeDaoImpl(){}

    public EmployeeDaoImpl(SessionFactory sessionFactory){
        this.sf = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sf;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sf = sessionFactory;
    }

    @Override
    public List findAll() {
        Session session = sf.openSession();
        Query query = session.createQuery("from Employee");

        return query.list();

    }

    @Override
    public List findAll(Integer id) {
        Session session = sf.openSession();
        Query query = session.createQuery("from Employee e where e.departments = " + id);

        return query.list();
    }

    @Override
    public List findAllWithout() {
        Session session = sf.openSession();
        Query query = session.createQuery("select e.id from Employee e");

        return query.list();
    }
}
