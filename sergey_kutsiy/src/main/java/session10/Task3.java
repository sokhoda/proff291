package session10;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Сергей on 31.01.2016.
 */
public class Task3 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
        Scanner scan = new Scanner(System.in);
        int dep_num=scan.nextInt();

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt = conn.createStatement();

            ResultSet rs= stmt.executeQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =" + dep_num);
            while (rs.next()) {
                System.out.printf("%15s \n", rs.getString("FIRST_NAME"));
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
