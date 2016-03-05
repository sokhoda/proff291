package session8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class ConnectEx {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");


        Connection conn = null;
//        String url = "jdbc:oracle:thin:@192.168.1.121:1521:XE";
        String url = "jdbc:postgresql://178.62.245.113:5432/junior_database";
        try {
            conn = DriverManager.getConnection(url, "root", "113113");
            System.out.println("Connection start");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
