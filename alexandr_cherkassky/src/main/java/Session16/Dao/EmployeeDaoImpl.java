package Session16.Dao;

import Session15.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Пк2 on 21.02.2016.
 */
@Component("emplDaoImpl")
public class EmployeeDaoImpl  implements EmployeeDao{
    @Autowired
    @Qualifier("sf")
    private SessionFactory factory;

    public EmployeeDaoImpl(){}

    /*public EmployeeDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }*/

    @Override
    public List getSalaryByEmplName(String FirstName, String LastName) {
        Session session=factory.getCurrentSession();
        try{
            Query query=session.createQuery("select salary from Employee e where e.firstName=:First and e.lastName=:Last");
            query.setParameter("First",FirstName);
            query.setParameter("Last",LastName);
            return query.list();

        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Transaction Failed");
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public List<Employee> findEmplByDeptId(int deptId) {
        return null;
    }

    @Override
    public List<Employee> findEmplNoDept() {
        return null;
    }




}
