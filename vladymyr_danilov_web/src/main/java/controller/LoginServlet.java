package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        String message = null;
        String address = "/login.jsp";

        if ( login.isEmpty() || password.isEmpty() ) {
            message = "Not all fields are filled!";
        } else if ( !RegisterUser.isContainUser(login) ) {
            message = "This login is not registered";
            address = "/registration.jsp";
        } else if ( !RegisterUser.getUsers().get("password")[0].equals(password) ) {
            message = "Wrong password!";
        } else {
            address = "/index.jsp";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(address).forward(request, response);

    }
}
