package session16.ses16.dao;

import session16.ses15.domain.Employee;

import java.util.List;

/**
 * Created by Юлия on 20.02.2016.
 */
public interface EmployeeDao {

    Long create(Employee employee);
    Employee findAllEmployee();

    List findAllEmployeeByDepartment(int dep_id);

    List findAllEmployeeWithNoDepartment();

}
