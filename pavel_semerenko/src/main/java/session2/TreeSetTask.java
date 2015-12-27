package session2;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Pavel on 20.12.2015.
 */
public class TreeSetTask {
    public static void run(){
        Set<User> users = new TreeSet<User>(new LoginAscComparator());

        users.add(new User("l", "p"));
        users.add(new User("l1", "p2"));
        users.add(new User("l1", "p2"));
        users.add(new User("l3", "p1"));

        System.out.println(users);
    }

}
