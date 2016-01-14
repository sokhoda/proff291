package session2;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Администратор on 20.12.2015.
 */
public class ComparEx {
    public static void main(String[] args){
    Set<User> userTreeSet = new TreeSet<>();
        userTreeSet.add(new User("we","weed"));
        userTreeSet.add(new User("wdgdbe","trrtweed"));
        userTreeSet.add(new User("were","weed"));
        userTreeSet.add(new User("wshe","wsreed"));

    Set<User> userTreeSet2 = new TreeSet<>(new LoginComparator(){//чтобы сразу сортировало
        @Override
        public int compare(User user1, User user2){
            return user1.getLogin().compareTo(user2.getLogin());
        }
    });
          userTreeSet2.addAll(userTreeSet);
        System.out.println(userTreeSet);
        System.out.println(userTreeSet2);
    }
}

class LoginComparator implements Comparator<User>{

    @Override
    public int compare(User o1, User o2) {
        return o1.getLogin().compareTo(o2.getLogin());
    }
}
