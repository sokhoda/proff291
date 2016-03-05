package session16.dao;



import session16.domain.Employee;

import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */
public interface EmployeeDao {
    List findAllEmployee();

    List findName(String firstName);

    // void create(Employee employee);
    Long create(Employee employee);

    Employee read(Long id);

    void update(Employee employee);
}
