package web.domain;

import java.util.List;

/**
 * Created by Юлия on 14.02.2016.
 */
public interface EmployeeDao {
    Long create(Employee user);
    Employee read(Long user);
    void update(Employee user);
    void delete(Employee user);



}
