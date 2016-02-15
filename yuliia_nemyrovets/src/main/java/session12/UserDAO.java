package session12;

import java.util.List;

/**
 * Created by Юлия on 07.02.2016.
 */
public interface UserDAO {

    Long create(User user);
    User read(Long user);
    void update(User user);
    void delete(User user);
    List<User> findAll(String name, int id);
    List <User> showByPortion(int id);



}
