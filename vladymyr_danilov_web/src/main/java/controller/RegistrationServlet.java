package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
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

        String login = parameterMap.get("login")[0].trim();
        String name = parameterMap.get("name")[0].trim();
        String surname = parameterMap.get("surname")[0].trim();
        String phone = parameterMap.get("phone")[0];
        String password = parameterMap.get("password")[0].trim();
        String confirmPassword = parameterMap.get("confirmPassword")[0].trim();

        String message = null;
        String address = "/registration.jsp";
        if ( RegisterUser.isContainUser(login) ) {
            message = "Sorry, This login is used";
        } else if ( login.isEmpty() || name.isEmpty() || surname.isEmpty() || password.isEmpty() || phone.isEmpty()
                || confirmPassword.isEmpty() ) {
            message = "Not all fields are filled";
        } else if ( !password.equals(confirmPassword) ) {
            message = "Please select right password!";
        } else {
            if ( RegisterUser.createUser(login, name, surname, phone, password, confirmPassword) ) {
                message = "Congrats, " + login + RegisterUser.showUsers().toString() + "! You have been registered";
                address = "/login.jsp";
            } else {
                message = "User error!";
            }
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher(address).forward(request, response);
    }
}
