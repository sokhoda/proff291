package session2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 20.12.15
 */
public class MapAuth {
    private Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        MapAuth auth = new MapAuth();
        boolean isPresent = auth.isAuthenticated("Piter", "Drugii");
        System.out.println("PiterII present: " + isPresent);
    }
    public MapAuth() {
        users.put("Piter", "Pershii");
        users.put("Viktor", "Pershii");
        users.put("Yulia", "Pershaya");
    }

    public boolean isAuthenticated(String login, String pass) {
        for (Map.Entry<String, String> userEntry : users.entrySet()) {
            if(userEntry.getKey().equals(login) && userEntry.getValue().equals(pass)) {
                return true;
            }
        }
        return false;
//        return hw5.users.containsKey(login) && hw5.users.get(login).equals(pass);
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }
}
