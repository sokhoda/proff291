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
@WebServlet("/authentification")
public class AuthServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // super.doGet(req, resp);
        Map<String, String[]> paramterMap = req.getParameterMap();
        String login = paramterMap.get("name")[0];
        String password = paramterMap.get("password")[0];
        String message = "";
        String page = "/loginClient.jsp";
        if (login.isEmpty() || password.isEmpty()) {
            message = "Enter all fields";

        } else {
            Authentification authentification = new Authentification();
            if (authentification.isClientExist(login)) {
                if (authentification.isAuthentified(login, password)) {
                    page = "/daxhboard.jsp";
                } else {
                    message = "Registration";
                }
                req.setAttribute("message", message);
                req.getRequestDispatcher(page).forward(req, resp);
            }
        }


    }

}
