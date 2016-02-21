package session15;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Solyk on 20.02.2016.
 */
public class EmployeeDaoImpl implements EmployeeDao {

    private SessionFactory sessionFactory;

    public EmployeeDaoImpl(){}

    public EmployeeDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Employee");

        return query.list();

    }

    @Override
    public List findAll(Integer id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from session13.Employee");
        session.close();
        sessionFactory.close();
        return query.list();
    }

    @Override
    public List findAllWithout(Integer id) {
        return null;
    }
}
