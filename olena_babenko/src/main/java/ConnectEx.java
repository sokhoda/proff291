/**
 * Created by lenchi on 31.01.16.
 *
 * Задание:
 необходимо выбрать и вывести на экран след инфу стр Employees
 Имя сотрудника, телефон, Зп
 */

import java.sql.*;
import java.util.Locale;
public class ConnectEx {
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

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT FIRST_NAME, PHONE_NUMBER, SALARY FROM employees");

            int i=0;
            while(rs.next()){
                System.out.println(++i +"\t"+rs.getString("FIRST_NAME")+"\t"+rs.getString("PHONE_NUMBER")+"\t"+rs.getString("SALARY"));
                //i++;
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
