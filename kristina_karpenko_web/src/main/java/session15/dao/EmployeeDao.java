package session15.dao;

import session15.domain.Employee;

import java.util.List;

/**
 * Created by Администратор on 20.02.2016.
 */
public interface EmployeeDao {

    Long create(Employee employee);
    Employee findAllEmployee();

    List findAllEmployeeByDepartment(int dep_id);

    List findAllEmployeeWithNoDepartment();
}
