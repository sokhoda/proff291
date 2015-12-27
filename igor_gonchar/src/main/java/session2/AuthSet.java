package session2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 20.12.2015.
 */
public class AuthSet {

    private Set<User> users = new HashSet<>();

    public static void main(String[] args) {
        AuthSet auth = new AuthSet();
        boolean isPresent = auth.authentication("aaa", "bbb");
        System.out.println("aaa is present: " + isPresent);
    }


    public AuthSet() {
        users.add(new User("aaa", "bbb"));
        users.add(new User("ccc", "ddd"));

    }

    public boolean authentication(String login, String password) {
        User us = new User(login, password);
       return users.contains(new User(login, password));


    }
}
