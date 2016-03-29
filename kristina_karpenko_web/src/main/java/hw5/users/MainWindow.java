package hw5.users;

import java.sql.Date;
import java.sql.SQLException;

public class MainWindow {
    public static void main(String[] args)throws ClassNotFoundException, SQLException {
        UserJDBCManager userJDBCManager = new UserJDBCManager();
        userJDBCManager.create(new User(1,"Kris2015","traum2015",new Date(116,01,03)));
        userJDBCManager.create(new User(2,"Kris2012","traum201",new Date(116,01,03)));
        userJDBCManager.findAll();
    }
}
