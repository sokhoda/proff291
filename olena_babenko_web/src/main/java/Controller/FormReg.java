package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenchi on 22.01.16.
 */
@WebServlet("/registration")
public class FormReg extends HttpServlet {
    public AccountService userRegistration = new AccountService();
    public Map<String, String> userMap = new HashMap<>();

    public void init() {
        try {
            userRegistration.getMapFromFile(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("UserLogin");
        String pass = request.getParameter("UserPass");

        if (userRegistration.Registration(login, pass, userMap)) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            response.getWriter().print("Registration is failed!\nUser with login " + login + " already exists.\nTry again!");
        }
    }
}
