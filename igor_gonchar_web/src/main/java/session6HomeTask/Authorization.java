package session6HomeTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Created by i.gonchar on 1/19/2016.
 */

@WebServlet("/authorizationForm")
public class Authorization extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        response.getWriter().println("<html>" + "<head><body><h1>HELLO</h1>" + date + "</body>" + "</head>" + "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];

        String pageAddress = "/index1.jsp";
        String message = authorizResult(login, password);
        if (message.equals("You are successfully validated")) {
            pageAddress = "/dashboard.jsp";
        }

        request.setAttribute("auth_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, response);
    }


    private String authorizResult(String login, String password) {
        Map<String, String> allUSers = RegisterBase.getUserMap();
        String message = "";

        if (login.isEmpty() && password.isEmpty()) {
            message = "Please enter data in the fields";
        } else if (login.isEmpty()) {
            message = "Empty login field";
        } else if (password.isEmpty()) {
            message = "Empty password field";
        } else if (allUSers.containsKey(login) && allUSers.get(login).equals(password)) {
            message = "You are successfully validated";
        } else if (allUSers.containsKey(login) && !allUSers.get(login).equals(password)) {
            message = "Incorrect password! Please re-enter";
        } else {
            message = "There is no such user";
        }
        return message;
    }
}
