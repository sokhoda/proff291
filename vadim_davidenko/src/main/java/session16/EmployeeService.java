package session16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionManager;
import java.util.List;

/**
 * Created by Вадим on 21.02.2016.
 */


public class EmployeeService {

    private EmployeeDaoImpl empDao = new EmployeeDaoImpl();

    @Autowired
    private TransactionManager txManager;

    @Transactional
    public List<Employee> getEmployeeSalary (String name) {
        return empDao.getSalary(name);
    }
}
