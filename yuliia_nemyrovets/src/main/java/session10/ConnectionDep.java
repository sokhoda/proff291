package session10;

        import java.sql.*;
        import java.util.Locale;
        import java.util.Scanner;

/**
 * Created by Юлия on 31.01.2016.
 */
public class ConnectionDep {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application is started...");
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";

        try {
            Scanner scanner=new Scanner(System.in) ;
            int i=scanner.nextInt();
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stnt = conn.createStatement();
            ResultSet rs=stnt.executeQuery("SELECT FIRST_NAME  FROM EMPLOYEES WHERE DEPARTMENT_ID="+i );

            while(rs.next()){

                System.out.printf("\n%20s", rs.getString("FIRST_NAME"));

            }

        } catch (SQLException e) {
            System.out.println("Connection is failed");
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
