package hw5.users;

import hw5.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by v.davidenko on 03.02.2016.
 */
public class MainWindow {

    public static void main(String[] args) throws SQLException {
        UserJDBCManager userMan = new UserJDBCManager();
        User newUser = new User(104, "vadim4", "12345", new Date());
        userMan.create(newUser);

        List<User> users = userMan.findAll();
        if (!users.isEmpty()) {
            for (User user : users) {
                System.out.println(user.toString()) ;
            }
        }

    }
}
