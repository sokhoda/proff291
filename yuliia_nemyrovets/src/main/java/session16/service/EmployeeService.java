package session16.service;

import session16.domain.Employee;

import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */
public interface EmployeeService {
    List findByName(String firstName);

    List findAll();

    Employee read(Long ig);
}
