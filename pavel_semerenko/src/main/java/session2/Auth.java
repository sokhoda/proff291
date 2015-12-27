package session2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Pavel on 20.12.2015.
 */
public class Auth {
    private Map<String, String> autUhsers;

    public Auth(){
        autUhsers = new HashMap<String, String>();

        autUhsers.put("user1", "pass1");
        autUhsers.put("user2", "pass2");
    }

    public boolean isAuthenticated(String log){
        return autUhsers.containsKey(log);
    }

    public void setUsers(Map<String, String> users) {
        autUhsers = users;
    }
}
