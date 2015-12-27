package session1;

import session2.Auth;

/**
 * Created by Pavel on 19.12.2015.
 */
public class HelloWorld {
    public static void main(String[] args) {
        Auth auth = new Auth();

        System.out.println(auth.isAuthenticated("user1"));
    }
}
