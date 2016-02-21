package session16;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import session12.dentist.domain.*;

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
    public List<Employee> findAll() {
        Session session = factory.openSession();
        try {
            return factory.openSession().createQuery("from Employee").list();
        } catch (HibernateException e) {
            log.error("Transaction failed");
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }
}
