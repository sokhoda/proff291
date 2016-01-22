package hw4.loginRegisterForm;

/**
 * Created by skuciy on 21.01.2016.
 */
public class User {
    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String login, String password) {
        this.login=login;
        this.password=password;
    }

    public User() {
    }
}
