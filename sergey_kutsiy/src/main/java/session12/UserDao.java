package session12;

import java.util.List;

/**
 * Created by Сергей on 07.02.2016.
 */
public interface UserDao {
    public User getUserByloginAndPassword (String  login, String password);
    public List<User> findAll ();
    public List<User> findAllWithoutUser (User user);
}
