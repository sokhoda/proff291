package session16.dao;

import session16.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
public interface EmployeeDao {
    Long create(Employee employee);
    Employee read(Long id);
    List<Employee> findAll();
}
