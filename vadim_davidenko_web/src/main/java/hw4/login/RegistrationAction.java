package hw4.login;

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
 * Created by Вадим on 17.01.2016.
 */

@WebServlet("/regform")
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
        String login = parameterMap.get("login")[0].trim();
        String password = parameterMap.get("password")[0].trim();
        String confirmPassword = parameterMap.get("confirmPassword")[0].trim();
        String name = parameterMap.get("name")[0].trim();
        String surname = parameterMap.get("surname")[0].trim();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String regDate = df.format(new Date());

        // Registration
        if (name.isEmpty() || surname.isEmpty() || login.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
            resp.getWriter().println("Please, fill in all fields");
            return;
            // stay on this page
        }
        if (!password.equals(confirmPassword)) {
            resp.getWriter().println("The password confirmation does not match!");
            return;
            // stay on this page
        }
        if (!Registration.isUserExist(login)) {
            String[] userData = new String[]{password, name, surname, regDate};
            if (Registration.addUser(login, userData)) {
                resp.getWriter().println("Your registration is successful. Congratulations!");
                resp.getWriter().println(Registration.printUserList());
                // go to Congratulations page
            }
        } else {
            resp.getWriter().println("Sorry, but user with such login is already registered.\nPlease, try another one.");
            // stay on this page
        }

    }


}
