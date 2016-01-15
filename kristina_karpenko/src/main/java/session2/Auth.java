package session2;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Администратор on 20.12.2015.
 */
public class Auth {

  private  static Set<User> users = new HashSet<>();//не по ООП. статик не правильно делать

    public  boolean isAuthenticated(String login, String password){
            return users.contains(new User(login,password));
    }


    public static void main(String[] args){
        Auth auth = new Auth();
        users.add(new User("Vasya","6666"));
        users.add(new User("Vas","123456"));
        users.add(new User("Olia","12"));
        users.add(new User("Kris","1212126"));


        boolean isPresent = auth.isAuthenticated("Kyturis","1212126");
        System.out.print("Is Present: "+isPresent);
    }
}
