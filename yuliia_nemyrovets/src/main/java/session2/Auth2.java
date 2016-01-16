package session2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Юлия on 20.12.2015.
 */
public class Auth2 {
    Map<String, String> user = new HashMap<>();

    public Map<String, String> getUser() {
        return user;
    }

    public void setUser(Map<String, String> user) {
        this.user = user;
    }

    public static void main(String[] args) {
        Auth2 auth = new Auth2();
        // auth.getUser().put("login","password");
        // auth.getUser().put("login","sdcv");
        Map<String, String> hashMap = auth.getUser();
        hashMap.put("Ira", "12340");
        hashMap.put("Erik", "98761");
        hashMap.put("Tom", "52161");
        boolean isPresent = auth.isAuthentification("Ira", "12340");
        System.out.println(isPresent);


    }


    public boolean isAuthentification(String login, String password) {
        return user.containsKey(login) && user.containsValue(password);
    }

}

