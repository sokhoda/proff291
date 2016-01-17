package hw4.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Вадим on 17.01.2016.
 */

@WebServlet("/registrationForm")
public class RegistrationAction extends HttpServlet {

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        String confirmPassword = parameterMap.get("confirmPassword")[0];
        String name = parameterMap.get("name")[0];
        String surname = parameterMap.get("surname")[0];

        // Registration
        if (name.isEmpty() || surname.isEmpty() || login.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
            resp.getWriter().println("Please, fill in all fields");
            return;
        }
        if (!password.equals(confirmPassword)) {
            resp.getWriter().println("Password and confirmed password are not matched! Please, confirm password.");
            return;
        }
        if (!Registration.isUserExist(login)) {
            String[] userData = new String[]{password, name, surname};
            if (Registration.addUser(login, userData)) {
                resp.getWriter().println("Your registration is successful. Congratulations!");
                resp.getWriter().println("Number of registered users: " + Registration.getUsersNumber());
            }
        } else {
            resp.getWriter().println("Sorry, but user with such login is already registered. Please, try another one.");
        }

    }


}
