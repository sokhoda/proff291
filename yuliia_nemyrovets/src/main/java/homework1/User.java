package homework1;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Юлия on 22.12.2015.
 */
public class User {
    private String login;
    private String password;
    private int date;
    private int rate;
    private String sex;
    private static HashSet<User> users = new HashSet<>();
    public HashSet<User> getUser() {
        return users;
    }

    public void setUser(HashSet<User>user) {
        this.users = user;
    }
    public User() {
    }

    public User(String login, String password, int date, int rate, String sex) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.rate = rate;
        this.sex = sex;
    }
    public User( String password, int date, int rate, String sex, String login) {
        this.login = login;
        this.password = password;
        this.date = date;
        this.rate = rate;
        this.sex = sex;
    }
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
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public int getRate() {
        return rate;
    }
    public void setRate(int rate) {
        this.rate = rate;
    }
    public String isSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User :" + login + " , " + password + " , " + date + " , " + rate + " , " + sex + ".";
    }

    @Override
    public boolean equals(Object obj) {
        User users = (User) obj;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        if (this.login == users.getLogin() && this.password == users.getPassword() && this.date == users.getDate() && this.rate == users.getRate() && this.sex == users.isSex()) {

            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getLogin().hashCode() + this.getPassword().hashCode() + this.getDate() + this.getRate() + this.isSex().hashCode();
    }


}
