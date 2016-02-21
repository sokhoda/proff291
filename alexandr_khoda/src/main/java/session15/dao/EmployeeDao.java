package session15.dao;

import java.util.List;

/**
 * Created by s_okhoda on 20.02.2016.
 */
public interface EmployeeDao {
    List findAll();
    List findAllDept(Long id);
    List findAllUnemployed();

}
