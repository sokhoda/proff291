package controller;

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

@WebServlet("/form")
public class FormProcessor extends HttpServlet {
    private Map<String, String> userMap;

    @Override
    public void init() throws ServletException {
        userMap = new HashMap<String, String>();
        userMap.put("vadim","password");
        userMap.put("igor","password");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];

        if (userMap.containsKey(login) && userMap.get(login).equals(password)) {
            resp.getWriter().println("Hello " + login);
        } else {
            resp.getWriter().println("Buy " + login);
        }
    }

}