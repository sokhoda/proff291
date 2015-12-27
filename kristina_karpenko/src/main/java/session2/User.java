package session2;

//логин и пароль строки
//создать класс с методом проверки существования пользователя

import java.util.Map;

public class User implements Comparable<User>{
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        User s = (User) o;
        if (login == s.getLogin() && password == s.getPassword()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getLogin().hashCode()+this.getPassword().hashCode();
    }

    @Override
    public int compareTo(User user) {
        return user.getPassword().length() - password.length();
    }

    @Override
    public String toString() {

        return "User.  Login:"+login+"   Password:"+password;
    }
}
