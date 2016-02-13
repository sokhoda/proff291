package session10;

import hw5.users.User;

import java.sql.*;
import java.util.Locale;
/**
 * Created by Solyk on 01.02.2016.
 */
public class UserSetEmploeeyrs {
    public static void main(String[] args) {
        User user = new User("Dima","Lyashenko");
        Locale.setDefault(Locale.ENGLISH);

        String insertUser = "INSERT INTO USERS(ID,LOGINS,PASSWORDS) VALUES(USERS_SEQ.nextval,'ff', 'tyui');";
        Connection connection = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            connection = DriverManager.getConnection(url,"notebooks","notebooks");
            Statement statement = connection.createStatement();
            statement.executeQuery(insertUser);
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
