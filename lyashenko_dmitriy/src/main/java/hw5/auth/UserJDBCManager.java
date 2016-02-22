package hw5.auth;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Solyk on 02.02.2016.
 */
public class UserJDBCManager {

    private ArrayList<User> users = new ArrayList<User>();
    private Connection connection;
    private final String url = "jdbc:oracle:thin:@localhost:1521:XE";


    public UserJDBCManager(){
        Locale.setDefault(Locale.ENGLISH);

    }

    public int create(User user){
        long idLong = 0;
        connection = null;

        String usersID = "SELECT ID FROM USERS WHERE LOGINS LIKE " + "'" + user.getLogin() + "'";
        String insertUser = "INSERT INTO USERS(ID,LOGINS,PASSWORDS,DATES_REGISTRATION) VALUES (USERS_SEQ.nextval," +
                "'" +  user.getLogin() + "'," + "'" + user.getPassword() + "'," + " TO_DATE(SYSDATE))";


        try {
            connection = DriverManager.getConnection(url,"notebooks","notebooks");
            Statement statement = connection.createStatement();

            statement.executeQuery(insertUser);

            ResultSet resultSet =  statement.executeQuery(usersID);

            if (resultSet.next()) {
                idLong = resultSet.getLong("ID");
                user.setId(idLong);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return 0;
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return (int)idLong;
    }
    public List findAll(){
        List<String> tmpList = new ArrayList<String>();
        connection = null;
        String usersFinedAll = "SELECT * FROM USERS";
        try {
            connection = DriverManager.getConnection(url,"notebooks","notebooks");
            Statement statement = connection.createStatement();

            ResultSet resultSet =  statement.executeQuery(usersFinedAll);

            while(resultSet.next()) {
                String resultOfQuery = resultSet.getLong("ID") + " " + resultSet.getString("LOGINS") + " " + resultSet.getString("PASSWORDS") + " " + resultSet.getString("DATES_REGISTRATION");
                tmpList.add(resultOfQuery);
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
           return null;
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return tmpList;

    }
    public User readByNamePass(String login, String pass){
        connection = null;
        String usersFinedByNamePass = "SELECT LOGINS, PASSWORDS FROM USERS WHERE LOGINS LIKE " + "'" + login + "' AND PASSWORDS LIKE " + "'" + pass + "'";
        try {
            connection = DriverManager.getConnection(url,"notebooks","notebooks");
            Statement statement = connection.createStatement();


            ResultSet resultSet =   statement.executeQuery(usersFinedByNamePass);
            if (resultSet.next()) {

              findAll();

            } else{

                System.out.println("Не верный логин или пароль");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return null;
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
      return new User(login, pass);
    }

}
