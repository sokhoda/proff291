package hw6.notes.domain;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Юлия on 16.02.2016.
 */
public class task1 {
    Connection conn = null;
    String url = "jdbc:oracle:thin:@localhost:1521:XE";
    Statement stnt = null;
    ResultSet rs = null;


    public void findAllEmployeeWorkingOnProject(int project_id) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            conn = DriverManager.getConnection(url, "firm", "firm");
            stnt = conn.createStatement();
            rs = stnt.executeQuery("SELECT* FROM EMPLOYEES WHERE PROJECT_ID=" + project_id);
            System.out.println("The result is:");
            while (rs.next()) {
                System.out.printf("\n%20s, %20s ", rs.getString("NAME"), rs.getString("EMPLOYEE_ID"));
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



    public void findAllProjectsForEmployee(int employee_id) {
        Locale.setDefault(Locale.ENGLISH);

        try {
            conn = DriverManager.getConnection(url, "firm", "firm");
            stnt = conn.createStatement();
            rs = stnt.executeQuery("SELECT p.PROJECT_ID, p.NAME FROM PROJECTS p,EMPLOYEES e WHERE p.MANAGER_ID=e.MANAGER_ID AND e.EMPLOYEE_ID=" + employee_id);
            System.out.println("The result is:");
            while (rs.next()) {
                System.out.printf("\n%20s, %20s ", rs.getString("NAME"), rs.getString("PROJECT_ID"));
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
