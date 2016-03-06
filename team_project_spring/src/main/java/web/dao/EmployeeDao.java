package web.dao;

import web.domain.Employee;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
public interface EmployeeDao {

    Long create(Employee employee);

    Employee read(Long id);

    boolean update(Employee employee);

    boolean delete(Employee employee);

    List<Employee> findAll();

    List<Employee> findByPortion(int page, int portionSize);
}
