package hw4.login;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Вадим on 17.01.2016.
 */
public class Registration {
    private static Map<String, String[]> users = new HashMap<String, String[]>();

    public static boolean addUser(String userLogin, String[] userData) {
        if (!users.containsKey(userLogin)) {
            users.put(userLogin, userData);
            return true;
        }
        return false;
    }

    public static boolean removeUser(String userLogin) {
        if (users.containsKey(userLogin)) {
            users.remove(userLogin);
            return true;
        }
        return false;
    }

    public static void clear() {
        users.clear();
    }

    public static String[] getUserData(String userLogin) {
        if (users.containsKey(userLogin)) {
            return users.get(userLogin);
        }
        return null;
    }

    public static Map<String, String[]> getUserMap(){
        return users;
    }

    public static int getSize() {
        return users.size();
    }

    public static boolean isUserExist(String userLogin) {
        return users.containsKey(userLogin);
    }

    public static String printUserList() {
        StringBuilder userList = new StringBuilder("\n| [login] | [password] | [Name] | [Surname] | [reg. date] |\n");
        userList.append("-----------------------------------------------------------\n");
        Set<Map.Entry<String, String[]>> entries = users.entrySet();
        for (Map.Entry entry : entries) {
            userList.append("| ");
            userList.append((String)entry.getKey());
            for (String value : (String[])entry.getValue()) {
                userList.append(" | ");
                userList.append(value);
            }
            userList.append(" |\n");
        }
        userList.append("-----------------------------------------------------------\n");
        userList.append("Number of registered users: ");
        userList.append(getSize());
        userList.append("\n");

        return userList.toString();
    }

}
