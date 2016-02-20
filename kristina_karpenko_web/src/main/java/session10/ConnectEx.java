package session10;

import java.sql.*;
import java.util.Locale;
public class ConnectEx {

        public static void main(String[] args) {

                Locale.setDefault(Locale.ENGLISH);
                System.out.println("Application is started...");
                Connection conn = null;
                String url = "jdbc:oracle:thin:@localhost:1521:XE";

                try {
                    conn = DriverManager.getConnection(url, "hr", "hr");
                    Statement stnt = conn.createStatement();

                    ResultSet rs=stnt.executeQuery("SELECT FIRST_NAME, PHONE_NUMBER, SALARY FROM EMPLOYEES" );
                    while(rs.next()){

                        System.out.printf("\n%20s %20s %20s ", rs.getString("FIRST_NAME"),rs.getString("PHONE_NUMBER" ),rs.getString("SALARY"));

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

