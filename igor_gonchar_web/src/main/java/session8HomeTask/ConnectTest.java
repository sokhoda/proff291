package session8HomeTask;

import java.sql.*;
import java.util.Locale;

/**
 * Created by i.gonchar on 2/1/2016.
 */
public class ConnectTest {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("Connection success");

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT REGION_NAME FROM REGIONS");

            while (result.next()) {
                String temp = String.format("%-20s", result.getString("REGION_NAME"));
                System.out.println(temp);
            }

        } catch (SQLException e) {
            System.out.println("Connection has failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.printf("Closing connection");
                } catch (SQLException e) {
                }
            }
        }
    }
}