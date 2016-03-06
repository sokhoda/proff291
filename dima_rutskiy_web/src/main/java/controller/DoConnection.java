package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;



/**
 * Created by Rrr on 31.01.2016.
 */

import org.hibernate.annotations.SourceType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;



import java.sql.*;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 5/12/13
 */
public class DoConnection {
    public ArrayList<String>
    doConnection() {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");
/*
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");
*/

        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        ArrayList<String> arr=new ArrayList<String>();
        try {
            conn = DriverManager.getConnection(url, "HR", "HR");
            Statement stmt=conn.createStatement();

            ResultSet rs=stmt.executeQuery("SELECT FIRST_NAME,PHONE_NUMBER,SALARY FROM employees WHERE DEPARTMENT_ID=60 ");
           // ArrayList<String> arr=new ArrayList<String>();
            /*while(rs.next()) {
                System.out.printf("Имя: %s   телефон: %s лет   зарплата: %s  \n", (rs.getString("FIRST_NAME")),(rs.getString("PHONE_NUMBER")),(rs.getString("SALARY")));

            }*/
            while(rs.next()) {
                arr.add(rs.getString("FIRST_NAME"));
            }
            System.out.println("Connection sucsessful");

        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return  arr;
    }

    public static void main(String[] args) {
        System.out.println(new DoConnection().doConnection());
    }
}

