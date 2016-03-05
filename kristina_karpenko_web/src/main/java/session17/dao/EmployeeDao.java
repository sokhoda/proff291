package session17.dao;

import session17.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
public interface EmployeeDao {
    List<Employee> findAll();
}
