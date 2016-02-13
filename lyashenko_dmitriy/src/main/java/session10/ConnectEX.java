package session10;

import java.sql.*;
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
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT FIRST_NAME, PHONE_NUMBER, SALARY  FROM EMPLOYEES");
            while(resultSet.next()){
                System.out.printf("\n%20s %20s %20s", resultSet.getString("FIRST_NAME"),resultSet.getString("PHONE_NUMBER"),resultSet.getInt("SALARY"));

//                System.out.print(resultSet.getString("FIRST_NAME"));
//                System.out.print(" ");
//                System.out.print(resultSet.getString("PHONE_NUMBER"));
//                System.out.print(" ");
//                System.out.print(resultSet.getString("SALARY"));
//                System.out.println();

            }
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
