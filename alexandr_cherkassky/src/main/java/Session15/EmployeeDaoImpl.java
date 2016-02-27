package Session15;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created by Пк2 on 20.02.2016.
 */
//public class EmployeeDaoImpl implements EmployeeDao {
//    private SessionFactory factory;
//
//
//    @Override
//    public List<Employee> findAll() {
//        Session thisSession=factory.openSession();
//        try{
//            //thisSession.beginTransaction();
//            Query thisQuery=thisSession.createQuery("from Employee");
//            //thisSession.getTransaction().commit();
//            return thisQuery.list();
//        } catch (Exception e){
//            e.printStackTrace();
//            thisSession.getTransaction().rollback();
//        } finally{
//            thisSession.close();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Employee> findEmplByDepartment() {
//        return null;
//    }
//
//    public  EmployeeDaoImpl(){}
//    public EmployeeDaoImpl(SessionFactory factory){
//        this.factory=factory;
//
//    }
//}
public class  EmployeeDaoImpl implements EmployeeDao {

    private static Logger log = Logger.getLogger(EmployeeDaoImpl.class);
    private SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;

    }

   // @Override
//    public List findAllEmployee() {
//        // List<Employee> list = new ArrayList<>();
//
//        Session session = factory.openSession();
//        try {
//            Query query = session.createQuery("from Employee");
//            // List<Object[]> list1 = query.list();
//
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//
//        }
//    }
//
//    @Override
//    public List findAllEmployeeByDepartment(int dep_id) {
//        Session session = factory.openSession();
//        try {
//            Query query = session.createQuery("from Employee WHERE DEPARTMENT_ID=" + dep_id);
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//
//        }
//    }
//
//    @Override
//    public List findAllEmployeeWithNoDepartment() {
//        Session session = factory.openSession();
//        try {
//            Query query = session.createQuery("FROM Employee WHERE DEPARTMENT_ID IS NULL ");
//            return query.list();
//        } catch (Exception e) {
//            log.error("Transaction is being failed");
//            return null;
//        } finally {
//            session.close();
//
//        }
//    }

    public static Logger getLog() {
        return log;
    }

    public static void setLog(Logger log) {
        EmployeeDaoImpl.log = log;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> findAll() {
        Session session = factory.openSession();
        try {
            Query query = session.createQuery("from Employee");
            // List<Object[]> list1 = query.list();

            return query.list();
        } catch (Exception e) {
            log.error("Transaction is being failed");
            return null;
        } finally {
            session.close();
            ;
        }
    }
}