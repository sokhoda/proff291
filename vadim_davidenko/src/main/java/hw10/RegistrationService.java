package hw10;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вадим on 02.02.2016.
 */
public interface RegistrationService {

    public void createUser(User user) throws SQLException;

    public boolean authorization(String login, String password) throws SQLException;

    public List getUserList() throws SQLException;
}
