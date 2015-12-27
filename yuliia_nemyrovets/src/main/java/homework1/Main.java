package homework1;

import java.util.HashSet;


/**
 * Created by Юлия on 22.12.2015.
 */
public class Main {
    private static HashSet<User> user = new HashSet<>();
    public HashSet<User> getUser() {
        return user;
    }

    public void setUser(HashSet<User>user) {
        this.user = user;
    }

    public boolean isAuthentification(String login, String password, int date, int rate, String sex) {
        User use = new User(login, password, date, rate, sex);
        return user.contains(use);
    }

    public static void main(String[] args) {
        Main auth = new Main();
        user.add(new User("Petre", "15611", 12, 12, "Men"));

        boolean isPresent = auth.isAuthentification("Petre", "15611", 12, 12, "Men");
        System.out.println(isPresent);

    }
}

