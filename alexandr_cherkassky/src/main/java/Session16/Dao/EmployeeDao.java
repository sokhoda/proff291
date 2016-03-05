package Session16.Dao;

import Session15.Employee;

import java.util.List;

/**
 * Created by Пк2 on 21.02.2016.
 */
public interface EmployeeDao {

    List<Employee> findAll();
    List<Employee> findEmplByDeptId(int deptId);
    List<Employee> findEmplNoDept();
    List getSalaryByEmplName(String firstName, String lastName);
}
