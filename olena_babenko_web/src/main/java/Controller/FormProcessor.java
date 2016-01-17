package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lenchi on 17.01.16.
 */

@WebServlet("/form")
public class FormProcessor extends HttpServlet {
   public String log;
   public String pass;

    //карта, на уровне инита ее заполняем, сравниваем
    public void init() {
        log = "User1";
        pass = "123456";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // или так
        String login = request.getParameter("Login");
        String pass = request.getParameter("Password");

        //или в виде карты значений
        //Map<String, String[]> parameterMap = request.getParameterMap();
        //String login = parameterMap.get("Login")[0];

        if (login.equals(log) && pass.equals(pass)) {//if Strings log and pass
            response.getWriter().print("Hello, user " + login);
        } else {
            response.getWriter().print("Bye, user " + login);
        }
    }
}
