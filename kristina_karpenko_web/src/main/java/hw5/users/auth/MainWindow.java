package hw5.users.auth;

public class MainWindow {
    public static void main(String[] args) {
    UserJDBCManager userJDBCManager = new UserJDBCManager();

    userJDBCManager.readByNamePass("Kris2012","traum201");
}
}
