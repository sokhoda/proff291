package session2.Ulia;

import java.util.HashSet;

/**
 * Created by Администратор on 25.12.2015.
 */
public class Main {
    private static HashSet<User> user = new HashSet<>();

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
