package session12;

import java.util.List;

/**
 * Created by Solyk on 07.02.2016.
 */
public interface IUserDAO {
    List findAllWithout(String login, String password);
    List findAll();
}
