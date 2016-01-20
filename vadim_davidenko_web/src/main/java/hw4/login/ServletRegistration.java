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

@WebServlet("/regForm")
public class ServletRegistration extends HttpServlet {

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
        String confirmPassword = parameterMap.get("confirmPassword")[0].trim();
        String name = parameterMap.get("name")[0].trim();
        String surname = parameterMap.get("surname")[0].trim();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String regDate = df.format(new Date());

        String msg = "";
        String msgName = "";
        String pageAddress = "/regform.jsp";

        if (name.isEmpty() || surname.isEmpty() || login.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
            msg = "Please, fill in all fields";
            msgName = "empty_field_err_msg";
        } else {
            if (!password.equals(confirmPassword)) {
                msg = "The password confirmation does not match!";
                msgName = "confirm_password_err_msg";
            } else {
                if (!Registration.isUserExist(login)) {
                    String[] userData = new String[]{password, name, surname, regDate};
                    if (Registration.addUser(login, userData)) {
                        msg = "Your registration is successful.<br/>Congratulations!";
                        msgName = "congratulations_msg";
                        request.setAttribute("users", Registration.getUserMap());
                    }
                } else {
                    msg = "Sorry, but user with such login is already registered.<br/>Please, try another one.";
                    msgName = "already_registered_msg";
                }
            }
        }
        request.setAttribute(msgName, msg);
        request.getRequestDispatcher(pageAddress).forward(request, response);
    }

}
