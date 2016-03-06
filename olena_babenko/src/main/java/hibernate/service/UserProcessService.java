package hibernate.service;

import hibernate.domain.UserProcess;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 25.05.13
 */
public interface UserProcessService {
    List<UserProcess> getAllUsers();
    void addNewUser(UserProcess user);
}
