package session15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Вадим on 20.02.2016.
 */
public class TestDao {

    private SessionFactory factory;

    public TestDao(SessionFactory factory) {
        this.factory = factory;
    }

    public TestDao() {}

    public List<Employee> findAll() {
        Session session = factory.openSession();
        try {
            return (List<Employee>)session.createQuery("FROM Employee").list();
        } finally {
            session.close();
        }
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }
}
