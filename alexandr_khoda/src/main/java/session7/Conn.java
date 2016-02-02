package session7;

import scala.collection.parallel.ParIterableLike;

import java.sql.*;
import java.util.Locale;

/**
 * Created by s_okhoda on 31.01.2016.
 */
public class Conn {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try{
            conn = DriverManager.getConnection(url, "hr", "hr");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.printf("\n%20s %20s %20s", rsmd.getColumnName(2), rsmd
                    .getColumnName(5), rsmd.getColumnName(8));

            while(rs.next()){
                System.out.printf("\n%20s %20s %20s", rs.getString(2), rs
                        .getString(5), rs.getString(8) );}
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
