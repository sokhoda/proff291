package session16.dao;

import session16.domain.Employee;

import java.util.List;

/**
 * Created by Home on 20.02.2016.
 */
public interface EmployeeDao {
    Integer create(Employee employee);
    void read(Long id);
    boolean delete(Employee employee);
    List<Employee> findAll();
    List<Employee> findByDep(Long depId);
    List<Employee> findEcceptDep(Long depId);
    List<Integer> getEmployeeSalaryByName(String name);
}
