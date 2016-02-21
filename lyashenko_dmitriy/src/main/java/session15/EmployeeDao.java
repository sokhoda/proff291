package session15;

import java.util.List;

/**
 * Created by Solyk on 20.02.2016.
 */
public interface EmployeeDao {
    List findAll();
    List findAll(Integer id);
    List findAllWithout(Integer id);
}
