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
            //int department = enterDepartmentId();
            ResultSet rs = stat.executeQuery("SELECT FIRST_NAME, DEPARTMENT_ID FROM employees WHERE DEPARTMENT_ID IS NOT NULL AND DEPARTMENT_ID = "+department);

            int i=0;
            while(rs.next()){
                System.out.println(++i +"\t"+rs.getString("FIRST_NAME")+"\t"+rs.getString("DEPARTMENT_ID"));
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
