package session16.service;

import session16.domain.Employee;

/**
 * Created by Home on 21.02.2016.
 */
public interface EmployeeService {
    Employee getEmployeeById(Long id);
    int getEmployeeSalaryByName(String name);
}
