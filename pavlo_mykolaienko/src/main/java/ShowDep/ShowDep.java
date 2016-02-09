package ShowDep;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Павло on 31.01.2016.
 */
public class ShowDep {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
/*
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");
*/
        String d = "";
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT FIRST_NAME,PHONE_NUMBER,SALARY FROM EMPLOYEES");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));

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

