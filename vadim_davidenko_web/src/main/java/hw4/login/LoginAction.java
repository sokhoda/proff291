package hw4.login;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by v.davidenko on 18.01.2016.
 */

@WebServlet("/loginform")
public class LoginAction extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String login = parameterMap.get("login")[0].trim();
        String password = parameterMap.get("password")[0].trim();

        // Authorization
        if (login.isEmpty() ||  password.isEmpty()) {
            resp.getWriter().println("Please, fill in all fields");
            return;
            // stay on this page
        }
        Authorization authorization = new Authorization();
        if (authorization.isLoginCorrect(login)) {
            if(authorization.isAuthorized(login, password)) {
                resp.getWriter().println("Your are logged successfully");
                // go to index.jsp page
            } else {
                resp.getWriter().println("Your password is incorrect!");
                // stay on this page
            }
        } else {
            resp.getWriter().println("Sorry, but user with such login is not registered yet.\nPlease, registration first.");
            // stay on this page
        }

    }



}
