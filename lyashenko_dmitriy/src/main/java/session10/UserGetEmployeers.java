package session10;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Solyk on 31.01.2016.
 */
public class UserGetEmployeers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner scan = new  Scanner(System.in);
        String tmp = scan.nextLine();
        String tt = "SELECT FIRST_NAME  FROM EMPLOYEES WHERE DEPARTMENT_ID = " + tmp;
        Connection connection = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            connection = DriverManager.getConnection(url,"hr","hr");
            Statement statement = connection.createStatement();

            ResultSet resultSet =  statement.executeQuery(tt);
            while(resultSet.next()){
                System.out.println(resultSet.getString("FIRST_NAME"));
            }

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
