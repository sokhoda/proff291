package session12;

import java.util.List;

public interface UserDao {
    Long cerate(User user);
    User read(Long id);
    void update(User user);
    void delete(User user);
    List<User> findAll();
    List<User> findAllByLogin(String name, String password);
}
