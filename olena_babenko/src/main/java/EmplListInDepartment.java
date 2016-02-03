import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Locale;

/**
 * Created by lenchi on 31.01.16.
 */
public class EmplListInDepartment {
    public static String enterDepartmentId() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Department ID:");
        return reader.readLine();
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        //int department = 60;
        try {
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stat = conn.createStatement();
            //String department = enterDepartmentId();
            ResultSet rs = stat.executeQuery("SELECT FIRST_NAME, DEPARTMENT_ID FROM employees WHERE DEPARTMENT_ID IS NOT NULL AND DEPARTMENT_ID = " + enterDepartmentId());

            int i = 0;
            System.out.println("N" + "\t" + "FIRST_NAME" + "\t" + "DEPARTMENT_ID");
            String name = "";
            while (rs.next()) {
                if (rs.getString("FIRST_NAME").length() < 7) {
                    name = rs.getString("FIRST_NAME") + "   ";
                } else {
                    name = rs.getString("FIRST_NAME");
                }

                System.out.println(++i + "\t " + name + "\t\t" + rs.getString("DEPARTMENT_ID"));
                //i++;
            }

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } catch (IOException e) {
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
