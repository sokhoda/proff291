package session15;

import java.util.List;

/**
 * Created by Pavel on 20.02.2016.
 */
public interface EmployeeDao {
    Long create(Employee employee);
    void read(Long id);
    void delete(Employee id);
    List<Employee> findAll();
    List<Employee> findByDep(Long pedId);
    List<Employee> findEcceptDep(Long depId);
}
