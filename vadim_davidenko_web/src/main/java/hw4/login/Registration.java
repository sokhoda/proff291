package hw4.login;

import java.io.*;
import java.util.*;

/**
 * Created by Вадим on 17.01.2016.
 */
public class Registration {

    private Map<String, String[]> users;
    private final static String USERS_BASE_FILE_PATH = "C:/users_base.txt";

    public Registration() {
        users = new LinkedHashMap<String, String[]>();
        readUsersBase();
    }

    public boolean addUser(String userLogin, String[] userData) {
        if (!users.containsKey(userLogin)) {
            users.put(userLogin, userData);
            writeUserToBase(userLogin, userData);
            return true;
        }
        return false;
    }

    public String[] getUserData(String userLogin) {
        if (users.containsKey(userLogin)) {
            return users.get(userLogin);
        }
        return null;
    }

    public Map<String, String[]> getUserMap(){
        return users;
    }

    public int getSize() {
        return users.size();
    }

    public boolean isUserExist(String userLogin) {
        return users.containsKey(userLogin);
    }

    public void writeUserToBase(String userLogin, String[] userData) {
        File file = new File(USERS_BASE_FILE_PATH);
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            if (!users.isEmpty()) {
                StringBuilder sb = new StringBuilder(userLogin);
                for (String value : userData) {
                    sb.append("\t");
                    sb.append(value);
                }
                sb.append("\n");
                pw.print(sb.toString());
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(pw!= null) {
                pw.close();
            }
        }
    }

    public void readUsersBase() {
        File file = new File(USERS_BASE_FILE_PATH);
        BufferedReader br = null;
        if (file.exists()) {
            try{
                br = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\t");
                    String login = values[0];
                    String[] data = Arrays.copyOfRange(values, 1, values.length);
                    users.put(login, data);
                }
            } catch(IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // Currently unused methods

    public void updateUsersBase() {
        File file = new File(USERS_BASE_FILE_PATH);
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
            if (!users.isEmpty()) {
                Set<Map.Entry<String, String[]>> entries = users.entrySet();
                for (Map.Entry entry : entries) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((String) entry.getKey());
                    for (String value : (String[]) entry.getValue()) {
                        sb.append("\t");
                        sb.append(value);
                    }
                    sb.append("\n");
                    pw.print(sb.toString());
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(pw!= null) {
                pw.close();
            }
        }
    }

    public boolean removeUser(String userLogin) {
        if (users.containsKey(userLogin)) {
            users.remove(userLogin);
            updateUsersBase();
            return true;
        }
        return false;
    }

    public void printUserList() {
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

        System.out.println(userList.toString());
    }

}
