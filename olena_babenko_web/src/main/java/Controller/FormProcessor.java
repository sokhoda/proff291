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
 * Created by lenchi on 17.01.16.
 */

@WebServlet("/form")
public class FormProcessor extends HttpServlet {
    public AccountService userAuthorization = new AccountService();
    public Map<String, String> userMap = new HashMap<>();

    //карта, на уровне инита ее заполняем, сравниваем в doPost
    public void init() {
        try {
            userAuthorization.getMapFromFile(userMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("Login");
        String password = request.getParameter("Password");

        if (userAuthorization.Authentication(login, password, userMap)) {//if Strings log and pass
            response.getWriter().print("Hello, user " + login + "!");
        } else if (userMap.containsKey(login) && !((String) userMap.get(login)).equals(userAuthorization.setPasswordMD5(password))) {
            response.getWriter().print("User " + login + " exists, but you entered incorrect password!");
        } else {
            request.getRequestDispatcher("regform.jsp").forward(request, response);
        }
    }
}

