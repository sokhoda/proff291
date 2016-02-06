package hw5.users;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Юлия on 05.02.2016.
 */
public class User {

    private String name;
    private String login;
    private int id;
    private String password;
    private Date date;

    public User() {

    }

    public User(String name, int id, String password, Date date) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.date = date;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
        return getName()+getId()+getPassword()+sdf.format(getDate().getTime());
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0 + name != null ? name.hashCode() : 0 + id + password != null ? password.hashCode() : 0 + (date != null ? date.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.getName() != null && this.getId() != 0 && this.getDate() != null && this.getLogin() != null && this.getPassword() != null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}
