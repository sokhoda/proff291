package hw9.service;

import hw9.domain.User;

import java.util.List;

/**
 * Created by i.gonchar on 2/29/2016.
 */
public interface UserService {
    boolean updateUser (User user);
    boolean removeUser (User user);
    Long createUser (User user);
    List getAllUsers();
}
