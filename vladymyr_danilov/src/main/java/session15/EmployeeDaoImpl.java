package session15;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
//@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {
//    private ApplicationContext context;
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    public EmployeeDaoImpl() {
//        context = new ClassPathXmlApplicationContext("session15/context-db.xml");
    }

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    //    @Autowired
    private SessionFactory factory;

    @Override
    public List<Employee> findAll() {
//        Session session = context.getBean("sf", SessionFactory.class).openSession();
        Session session = factory.openSession();
        try {
            return session.createQuery("from session15.Employee").list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
