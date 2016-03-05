package session16.ses16.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import session16.ses16.dao.EmployeeDao;
import session16.ses16.dao.EmployeeDaoIml;
import session16.ses15.domain.Employee;
//import session16.ses16.dao.EmployeeDao;
//import session16.ses16.dao.EmployeeDaoIml;
//import session16.ses16.domain.Employee;

/**
 * Created by Администратор on 21.02.2016.
 */
@Repository
@Transactional
public class ServiceEmployee {

    public ServiceEmployee(){}

    public Employee findByName( ){
        EmployeeDao employeeDao = new EmployeeDaoIml();
        Employee employee = employeeDao.findAllEmployee();
        return employee;
    }
}
