package session15.domain.session15.dao;

import java.util.List;

/**
 * Created by Юлия on 20.02.2016.
 */
public interface EmployeeDao {

    List findAllEmployee();

    List findAllEmployeeByDepartment(int dep_id);

    List findAllEmployeeWithNoDepartment();

}
