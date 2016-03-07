package SpringHibernateTransaction.service;

import SpringHibernateTransaction.domain.Employee;

import java.util.List;

/**
 * Created by lenchi on 21.02.16.
 */
public interface EmployeeServiceDAO {
    List<Employee> getAll();
    Integer getSalaryForEmployee(String EmployeeFirstName);
}
