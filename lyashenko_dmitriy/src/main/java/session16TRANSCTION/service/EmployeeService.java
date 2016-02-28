package session16TRANSCTION.service;

import session16TRANSCTION.domain.Employee;

import java.util.List;

/**
 * Created by Solyk on 21.02.2016.
 */
public interface EmployeeService {
    Long create(Employee ntb);
    Employee read(Long ig);
    boolean update(Employee ntb);
    boolean delete(Employee ntb);
    List findAll();
}
