package hibernate.dao;

import java.util.List;
import hibernate.domain.UserProcess;

/**
 * Created by lenchi on 07.02.16.
 */
public interface UserProcessDAO {
    Long create(UserProcess user);
    UserProcess read(Long id);
    List<UserProcess> findAll();
    void update(UserProcess user);
    void delete(UserProcess user);
}
