package session2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Home on 20.12.2015.
 */
public class AuthMap {

    private Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        AuthMap auth = new AuthMap();
        boolean isPresent = auth.authentication2("aaa", "bbb");
        System.out.println("aaa is present: " + isPresent);
    }


    public AuthMap() {
        users.put("aaa", "bbb");
        users.put("ccc", "ddd");
    }

    public boolean authentication(String login, String password) {
         return users.containsKey(login);
    }

    public boolean authentication2(String login, String password) {
        Set<Map.Entry<String, String>> entries = users.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(login) && entry.getValue().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }
}
