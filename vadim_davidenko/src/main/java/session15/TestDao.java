package session15;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Вадим on 20.02.2016.
 */

@Repository("empDao")
public class TestDao {

    @Autowired
    private SessionFactory factory;

    public TestDao(SessionFactory factory) {
        this.factory = factory;
    }

    public TestDao() {}

    public List<Employee> findAll() {
        Session session = factory.openSession();
        try {
            return (List<Employee>)session.createQuery("select firstName from Employee").list();
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
