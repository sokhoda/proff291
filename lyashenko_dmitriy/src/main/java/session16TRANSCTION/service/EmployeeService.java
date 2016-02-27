package session16TRANSCTION.service;

import session16.Employee;
import session16TRANSCTION.domain.Emloyee;

import java.util.List;

/**
 * Created by Solyk on 21.02.2016.
 */
public interface EmployeeService {
    Long create(Emloyee ntb);
    Emloyee read(Long ig);
    boolean update(Emloyee ntb);
    boolean delete(Emloyee ntb);
    List findAll();
}
