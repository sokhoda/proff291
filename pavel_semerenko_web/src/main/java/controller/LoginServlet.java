package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Pavel on 22.01.2016.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error_msg = "Ты неверный логин или пароль ввел! Тебе ту не рады!";
        Map<String, String[]> parameterMap = req.getParameterMap();

        String login = parameterMap.get("login")[0].trim();
        String password = parameterMap.get("password")[0].trim();


        req.setAttribute("error_message", error_msg);
        //req.getRequestDispatcher("/index_main.jsp").forward(req, resp);

        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
