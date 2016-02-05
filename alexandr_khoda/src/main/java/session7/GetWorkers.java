package session7;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by s_okhoda on 31.01.2016.
 */
public class GetWorkers {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите id департамента");
        int depID = scan.nextInt();

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try{
            conn = DriverManager.getConnection(url, "Notebooks", "notebooks");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees where " +
                    "DEPARTMENT_ID = " + depID);

            stmt.executeUpdate("INSERT INTO NOTES Value (NOTE_SEQ.NEXTVALUE, 'myNote')");


            System.out.println("Список сотрудников департамента с ИД=" +
                    depID + ":");

            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.printf("\n%20s %20s %20s %20s", rsmd.getColumnName(2), rsmd
                    .getColumnName(5), rsmd.getColumnName(8), rsmd
                    .getColumnName(11));


            while(rs.next()){
                System.out.printf("\n%20s %20s %20s %20s", rs.getString(2), rs
                        .getString(5), rs.getString(8), rs.getString(11) );}
        }
        catch (SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
        finally {
            if (conn != null){
                try {
                    conn.close();
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
