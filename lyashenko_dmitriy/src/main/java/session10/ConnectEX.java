package session10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by Solyk on 31.01.2016.
 */
public class ConnectEX {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Connection connection = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            connection = DriverManager.getConnection(url,"hr","hr");
            System.out.print("OK");
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
