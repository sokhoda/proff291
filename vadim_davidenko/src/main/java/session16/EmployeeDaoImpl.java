package session16;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Repository("empDao")
public class EmployeeDaoImpl {
    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);

    @Autowired
    private SessionFactory mySessionFactory;

    public List<Employee> getSalary(String name){
        return mySessionFactory.getCurrentSession().createQuery("select firstName from Employee").list();
    }
}
