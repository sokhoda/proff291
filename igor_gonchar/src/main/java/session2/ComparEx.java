package session2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.12.15
 */
public class ComparEx {
    public static void main(String[] args) {
        Set<User> usersSet = new TreeSet<>(new LoginAscComparator());
        usersSet.add(new User("1", "1"));
        usersSet.add(new User("1", "33"));
        usersSet.add(new User("3", "555"));

        Set<User> usersSetDesc = new TreeSet<>(new LoginAscComparator() {
            @Override
            public int compare(User user1, User user2) {
                return user2.getLogin().compareTo(user1.getLogin());
            }
        });
        usersSetDesc.addAll(usersSet);
        System.out.println(usersSetDesc);
    }
}

class LoginAscComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getLogin().compareTo(user2.getLogin());
    }
}