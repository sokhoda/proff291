package session6HomeTask;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by i.gonchar on 1/19/2016.
 */
public class RegisterBase {


    private static Map<String, String> userMap = new HashMap<>();


    public static String showUserMap() {
        List<String> log_pass = new ArrayList<>();
        for (Map.Entry<String, String> pair : userMap.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            log_pass.add(key + ": " + value);
        }
        return log_pass.toString();
    }


    public static Map<String, String> getUserMap() {
        return userMap;
    }

    public static void setUserMap(String key, String value) {
        RegisterBase.userMap.put(key, value);
    }

}
