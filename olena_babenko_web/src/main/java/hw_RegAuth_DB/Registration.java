package hw_RegAuth_DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by lenchi on 05.02.16.
 */
@WebServlet("/registration_page")
public class Registration extends HttpServlet {
    public UserProcessingMethods userProcessing = new UserProcessingMethods();

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("UserLogin");
        String pass = request.getParameter("UserPass");

        if (userProcessing.Registration(login, pass)) {
            request.getRequestDispatcher("index_session17.jsp").forward(request, response);
        } else {
            response.getWriter().print("Registration is failed!\nUser with login " + login + " already exists.\nTry again!");
        }
    }
}
