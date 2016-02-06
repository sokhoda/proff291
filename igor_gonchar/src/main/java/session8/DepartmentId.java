package session8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Locale;

/**
 * Created by Home on 31.01.2016.
 */
public class DepartmentId {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Enter an ID of department: ");
        String userInput = br.readLine();

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt = conn.createStatement();

            ResultSet result = stmt.executeQuery("SELECT FIRST_NAME, PHONE_NUMBER, SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID=" + userInput);

            int counter = 0;
            while (result.next()) {
                System.out.printf("%-20s %-20s %-20s" + "\n", result.getString("FIRST_NAME"), result.getString("PHONE_NUMBER"), result.getString("SALARY"));
                counter++;
            }

            if (counter == 0) {
                System.out.println("There is no data for your request");
            }

        } catch (SQLException e) {
            System.out.println("Connection has failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                System.out.println("Closing connction");
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
