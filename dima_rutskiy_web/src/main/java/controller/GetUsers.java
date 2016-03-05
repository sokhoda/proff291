package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

/**
 * Created by Rrr on 17.01.2016.
 */
@WebServlet("/GetUsers")
public class GetUsers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println("Application started...");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
            return;
        }
        System.out.println("JDBC driver is loaded!");


                Connection conn = null;
                String url = "jdbc:oracle:thin:@localhost:1521:XE";


        // Set response content type
                resp.setContentType("text/html");
                PrintWriter out = resp.getWriter();
                String title = "Database Result";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " +
                        "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n");

                try {
                    conn = DriverManager.getConnection(url, "TAXI", "TAXI");
                    Statement stmt=conn.createStatement();

                    ResultSet rs=stmt.executeQuery("SELECT CLIENT,AMOUNT,ADRESSFROM,ADRESSTO FROM ORDERS  ");
            /*while(rs.next()) {
                System.out.printf("Имя: %s   телефон: %s лет   зарплата: %s  \n", (rs.getString("FIRST_NAME")),(rs.getString("PHONE_NUMBER")),(rs.getString("SALARY")));

            }*/
                    while(rs.next()) {
                        String client= rs.getString("CLIENT");
                        String amount= rs.getString("AMOUNT");
                        String adressfrom= rs.getString("ADRESSFROM");
                        String adressto= rs.getString("ADRESSTO");

                        out.println("CLIENT "+client);
                        out.println("AMOUNT "+amount);
                        out.println("ADRESSFROM "+adressfrom);
                        out.println("ADRESSTO "+adressto+"<br>");
                    }

                    out.println("Connection sucsessful");
                    out.println("</body></html>");


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

            }


        //RequestDispatcher dispatcher=req.getRequestDispatcher("\\HomeworkSession3\\successRegistration.jsp");
        //dispatcher.forward(req,resp);


    }



