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

@WebServlet("/loginForm")
public class ServletLogin extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0].trim();
        String password = parameterMap.get("password")[0].trim();

        String msg = "";
        String msgName = "";
        String pageAddress = "/login_form.jsp";

        if (login.isEmpty() ||  password.isEmpty()) {
            msg = "Please, fill in all fields";
            msgName = "empty_field_err_msg";
        } else {
            Authorization authorization = new Authorization();
            if (authorization.isLoginCorrect(login)) {
                if (authorization.isAuthorized(login, password)) {
                    pageAddress = "/sample.jsp";
                } else {
                    msg = "Your password is incorrect!";
                    msgName = "wrong_password_err_msg";
                }
            } else {
                msg = "Sorry, but user with such login is not registered yet. Please, registration first.";
                msgName = "not_registered_err_msg";
            }
        }
        request.setAttribute(msgName, msg);
        request.getRequestDispatcher(pageAddress).forward(request, response);
    }

}
