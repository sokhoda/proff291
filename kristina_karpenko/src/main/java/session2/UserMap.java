package session2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Администратор on 20.12.2015.
 */
public class UserMap {
    Map<String, String> users = new HashMap<>();

    public Map<String, String> getUsers() {//вернуть всех юзеров
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    public static void main(String[] args) {

        UserMap auth = new UserMap();                                      //создаем объект Ауса
        Map<String, String> users = auth.getUsers();                    //переносим юзеров из Ауса

        users.put("kris", "23www");
        users.put("32w", "wwewe");
        users.put("wwwwww", "wwwrw");
        //System.out.println(hw5.users.containsKey("kris"));
        System.out.println("Is present: " + auth.isAuthenticated("32w", "wwewe"));
    }

    public boolean isAuthenticated(String login, String password) {
       // return hw5.users.containsKey(login) && hw5.users.containsValue(password);
        for(Map.Entry<String,String> use:users.entrySet()){
            if(use.getKey().equals(login) && use.getValue().equals(password))
                return true;
        }
    return false;
    }
}