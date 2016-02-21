package session16.dao;

import org.hibernate.HibernateException;
import session16.domain.Employee;

import java.util.List;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public interface EmployeeDao {

    void create(Employee employee);
    Employee read(Long id);
    void update(Employee employee);
    void delete(Employee employee);
    List findAll();
    List findAllDept(Long id);
    List findAllUnemployed();
    Integer getESalary(String name);
}
