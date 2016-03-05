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
@WebServlet("/login_page")
public class Login extends HttpServlet {
    public UserProcessingMethods userProcessing = new UserProcessingMethods();

    public void init() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");

        if (userProcessing.Authentication(login,password)==0) {
            request.getRequestDispatcher("usersListFromDB.jsp").forward(request, response);
            //response.getWriter().print("Hello, user " + login + "!");
        } else if (userProcessing.Authentication(login,password)==2) {
            response.getWriter().print("User " + login + " exists, but you entered incorrect password!");
        } else {
            request.getRequestDispatcher("regform_w_db.jsp").forward(request, response);
        }
    }
}
