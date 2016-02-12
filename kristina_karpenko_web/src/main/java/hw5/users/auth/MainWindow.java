package hw5.users.auth;

import java.sql.SQLException;

public class MainWindow {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    UserJDBCManager userJDBCManager = new UserJDBCManager();

    userJDBCManager.readByNamePass("Kris2012","traum201");
}
}
