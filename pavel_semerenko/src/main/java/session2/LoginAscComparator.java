package session2;

import java.util.Comparator;

/**
 * Created by Pavel on 20.12.2015.
 */
public class LoginAscComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o2.login.compareTo(o1.login);
    }
}
