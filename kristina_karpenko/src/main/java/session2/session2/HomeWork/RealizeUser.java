package session2.session2.HomeWork;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 25.12.2015.
 */
public class RealizeUser {
    public static void main(String[]args){
        User auth = new User();
       Set<User> users = auth.getUsers();

       //Set<User> hw5.users = new HashSet<>();
        users.add(new User("Kris2015", "123qwe","31 OCT 2015", 4.4,false));
        users.add(new User("Kris", "Kris","31 DEC 2015", 2.4,false));
        users.add(new User("Vitya", "123","20 JUN 2015", 4.0,true));
        users.add(new User("Vitalay2016", "qwe2016","31 OCT 2015", 4.4,true));
        users.add(new User("Kris2015", "123qwe","1 OCT 2014", 3.4,false));
        users.add(new User("Lera", "lera2012","31 NOV 2013", 5.0,false));
        users.add(new User("Nadia", "naduz","31 AUG 2015", 1.4,false));
        auth.setUsers(users);
        System.out.println(auth);
        users.add(new User("Vitya", "123","20 JUN 2015", 4.0,true));

       System.out.println(users.contains(new User("Kris2015", "123qwe","31 OCT 2015", 4.4,false)));//true
       // System.out.println(hw5.users.contains(new User("Kristy", "123qwe","31 OCT 2015", 4.4,false)));//false
        System.out.println(users.hashCode());

    }
}
