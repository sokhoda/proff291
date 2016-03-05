package session10;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Сергей on 31.01.2016.
 */
public class Task1 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");


        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1522:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM employees");
            int count =0;

            while (rs.next()) {
                System.out.printf("%15s", rs.getString("FIRST_NAME"));
                System.out.printf("%20s", rs.getString("PHONE_NUMBER"));
                System.out.printf("%7s", rs.getString("SALARY"));
                System.out.println();
                count++;
            }

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
