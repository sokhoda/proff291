package session16.service;

import session16.domain.Employee;

import java.util.List;

/**
 * Created by Home on 21.02.2016.
 */
public interface EmployeeService {
    Integer createEmployee(Employee employee);
    boolean deleteEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    List<Integer> getEmployeeSalaryByName(String name);
}
