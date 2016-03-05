package session2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by s_okhoda on 20.12.2015.
 */
public class TreeSetEx {
    private Set<User> users2 = new TreeSet<User>(new LoginAscComparator());

    public Set<User> getUsers2() {
        return users2;
    }

    public TreeSetEx() {
    }
//    public void setUsers2(Set<User> users2) {
//        this.users2 = users2;
//    }

    public TreeSetEx(TreeSet<User> users) {
        this.users2 = users;
    }

    public void addUser(String login, String pass) {
        users2.add(new User(login, pass));
    }

    class LoginAscComparator implements Comparator<User> {
        @Override
        public int compare(User user1, User user2) {
            return user1.getLogin().compareTo(user2.getLogin());
        }
    }

    public static void main(String[] args) {

        //TreeSet<User> hw5.users = new TreeSet<User>(new LoginAsComparator());
        TreeSetEx tr1 = new TreeSetEx();

        tr1.addUser("1", "1111");
        tr1.addUser("2", "22");
        tr1.addUser("3", "333");
        System.out.println(tr1.getUsers2());
    }
}
