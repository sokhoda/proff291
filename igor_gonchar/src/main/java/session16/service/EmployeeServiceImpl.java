package session16.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import session16.dao.EmployeeDao;
import session16.domain.Employee;

/**
 * Created by Home on 21.02.2016.
 */
@Repository("empService")
public class EmployeeServiceImpl implements EmployeeService {
    ApplicationContext context = new ClassPathXmlApplicationContext("session16/transactionalContext.xml");

    @Autowired(required = true)
    private EmployeeDao empDao;


    public EmployeeServiceImpl(EmployeeDao employeeDao){
        this.empDao = employeeDao;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }


    @Override
    public int getEmployeeSalaryByName(String name) {
        return empDao.getEmployeeSalaryByName(name);
    }
}
