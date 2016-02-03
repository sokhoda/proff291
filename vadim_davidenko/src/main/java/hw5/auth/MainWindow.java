package hw5.auth;

import hw5.auth.*;
import hw5.auth.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by v.davidenko on 03.02.2016.
 */
public class MainWindow {
    public static void main(String[] args) throws SQLException {
        UserJDBCManager userMan = new UserJDBCManager();

        User user = userMan.readByNamePass("vadim2", "12345");
        System.out.println("\n" + user);

    }

}
