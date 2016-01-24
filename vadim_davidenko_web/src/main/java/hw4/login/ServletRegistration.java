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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        String login = parameterMap.get("login")[0].trim();
        String password = parameterMap.get("password")[0].trim();
        String confirmPassword = parameterMap.get("confirmPassword")[0].trim();
        String name = parameterMap.get("name")[0].trim();
        String surname = parameterMap.get("surname")[0].trim();
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        String regDate = df.format(new Date());
        String msg = "";
        String pageAddress = "hw4/reg_form.jsp";
        boolean isAdded = false;

        if (name.isEmpty() || surname.isEmpty() || login.isEmpty() ||
                password.isEmpty() || confirmPassword.isEmpty()) {
            msg = "Please, fill in all fields";
        } else {
            if (!password.equals(confirmPassword)) {
                msg = "The password confirmation does not match!";
            } else {
                if (!Registration.isUserExist(login)) {
                    String[] userData = new String[]{password, name, surname, regDate};
                    synchronized (ServletRegistration.class) {
                        isAdded = Registration.addUser(login, userData);
                    }
                }
                if (isAdded) {
                    msg = "Your registration is successful. Congratulations!";
                    pageAddress = "hw4/users_base.jsp";
                    req.setAttribute("users", Registration.getUserMap());
                } else {
                    msg = "Sorry, but user with such login is already registered. Please, try another one.";
                }
            }
        }
        req.setAttribute("server_msg", msg);
        req.getRequestDispatcher(pageAddress).forward(req, resp);
    }

}
