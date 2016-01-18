package hw4.login;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вадим on 17.01.2016.
 */
public class Registration {
    private static Map<String, String[]> users = new HashMap<String, String[]>();

    public static void addAllUsers(HashMap<String, String[]> newUsers){
        users = newUsers;
    }

    public static boolean addUser(String userLogin, String[] userData) {
        if (!users.containsKey(userLogin)) {
            users.put(userLogin, userData);
            return true;
        }
        return false;
    }

    public static String[] getUserData(String userLogin) {
        if (users.containsKey(userLogin)) {
            return users.get(userLogin);
        }
        return null;
    }

    public static boolean removeUser(String userLogin) {
        if (users.containsKey(userLogin)) {
            users.remove(userLogin);
            return true;
        }
        return false;
    }

    public static void removeAllUsers() {
        users.clear();
    }

    public static int getUsersNumber() {
        return users.size();
    }

    public static boolean isUserExist(String userLogin) {
        return users.containsKey(userLogin);
    }

}
