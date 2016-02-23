package session16.service;

import java.util.List;

/**
 * Created by Юлия on 22.02.2016.
 */
public interface EmployeeService {
    List findByName(String name);

    List findAll();
}
