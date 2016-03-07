package hw9.dao;

import hw9.domain.User;

import java.util.List;

/**
 * Created by i.gonchar on 2/29/2016.
 */
public interface UserDao {
    long createUser(User user);
    boolean update(User user);
    boolean delete(User user);
    User read(Long id);
    List findAll();
    User findByLogin(String login);
    User findByLoginAndPassword(String login, String password);
}
