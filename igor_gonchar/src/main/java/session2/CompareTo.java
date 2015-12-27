package session2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Home on 20.12.2015.
 */
public class CompareTo {
    public static void main(String[] args) {
        Set<User> userSet = new TreeSet<>(new LoginAscendanceComparator());
        userSet.add(new User("2", "111111"));
        userSet.add(new User("22", "22"));
        userSet.add(new User("223", "333"));

        System.out.println(userSet);
    }
}

class LoginAscendanceComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getLogin().compareTo(user2.getLogin());
    }
}
