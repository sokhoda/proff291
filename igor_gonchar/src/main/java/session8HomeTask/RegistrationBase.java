package session8HomeTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Home on 31.01.2016.
 */
public class RegistrationBase {
    Connection conn = null;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";

    public void connectToBase() {

        Locale.setDefault(Locale.ENGLISH);

        try {
            conn = DriverManager.getConnection(url, "notebooks", "notebooks");
            System.out.println("Connection was successful");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection was not opened");
        }
    }

    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection was closed");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Connection was not closed");
            }

        }

    }

    public StringBuilder addUser(String login, String password){
        return null;

    }

}

