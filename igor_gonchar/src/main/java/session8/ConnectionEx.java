package session8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Locale;

/**
 * Created by Home on 31.01.2016.
 */
public class ConnectionEx {
    public static void main(String[] args) throws SQLException, IOException {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("1. Application has started");

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try{
            conn = DriverManager.getConnection(url, "hr", "hr");
            System.out.println("2. We have connected");
            Statement stmt = conn.createStatement();
           // stmt.executeQuery("SELECT * FROM employees");

           // stmt.executeQuery("SELECT FIRST_NAME, PHONE_NUMBER, SALARY FROM EMPLOYEES");

            ResultSet result = stmt.executeQuery("SELECT FIRST_NAME, PHONE_NUMBER, SALARY FROM EMPLOYEES");
           while(result.next()){
              /* System.out.print(result.getString("FIRST_NAME") + "\t" +
               result.getString("PHONE_NUMBER") + "\t" +
               result.getString("SALARY") + "\n");*/

               System.out.printf("%-20s %-20s %-20s" + "\n",result.getString("FIRST_NAME"),  result.getString("PHONE_NUMBER"),  result.getString("SALARY"));
           }

        } catch (SQLException e) {
            System.out.println("Connection has failed");
            e.printStackTrace();
        } finally {
            if (conn != null){
                System.out.println("3. Closing connction");
                conn.close();
            }
        }
    }
}
