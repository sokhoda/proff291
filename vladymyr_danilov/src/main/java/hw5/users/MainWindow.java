package hw5.users;

import java.sql.SQLException;
import java.util.Date;

public class MainWindow {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserJDBCManager userManager = new UserJDBCManager();
        User user = new User(13, "Serg", "123", new Date());
        userManager.create(user);
    }
}
