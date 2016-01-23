package controller;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class RegisterUser {
    private static Map<String, String[]> users = new LinkedHashMap<>();

    public RegisterUser() {

    }

    public static boolean createUser(String login, String name, String surname, String phone, String password, String confirmPassword) {
        if (!users.containsKey(login)) {
            String[] data = new String[]{name, surname, phone, password, confirmPassword};
            users.put(login, data);
            
            return true;
        } 
        return false;
    }

    public static boolean removeUser(String login) {
        if (users.containsKey(login)) {
            users.remove(login);
            return true;
        }
        return false;
    }

    public static boolean isContainUser(String login) {
        return users.containsKey(login);

    }

    public static Map<String, String[]> getUsers() {
        return users;
    }

    public static List<String> showUsers() {
        List<String> userList = new LinkedList<>();
        for ( String entry : users.keySet() ) {
            userList.add(entry);
        }

        return userList;
    }

}
