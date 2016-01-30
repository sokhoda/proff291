package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 22.01.2016.
 */
public class Users {
    String login;
    String pass;
    List<Users> users;

    public Users() {
        users = new ArrayList<Users>();
        users.add(new Users("user", "password"));
    }

    public Users(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public List<Users> getUsers() {
        return users;
    }
}
