package taxi.Action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Юлия on 22.01.2016.
 */
@WebServlet("/Registration")
public class RegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Registration registration = new Registration();
        String name = parameterMap.get("name")[0].trim();
        String surname = parameterMap.get("surname")[0].trim();
        String address = parameterMap.get("address")[0].trim();
        String phone = parameterMap.get("phone")[0].trim();
        String login = parameterMap.get("login")[0].trim();
        String password = parameterMap.get("password")[0].trim();
        String repeatPassword = parameterMap.get("repeatPassword")[0].trim();
        String message = "";
        String page = "/registeredClient";
        if (name.isEmpty() || surname.isEmpty() || address.isEmpty() || phone.isEmpty() || login.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            message = "Enter all fields";
        } else if (!repeatPassword.equals(password)) {
            message = "Check your password";
        } else if (registration.isExist(login)) {
            message = "Congratulation";
            req.setAttribute("Clients", registration.getClients());
            page = "/loginClients";
        } else {
            message = "The client with such login is already exist";
        }

        req.setAttribute("message", message);
        req.getRequestDispatcher(page).forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);

    }

}
