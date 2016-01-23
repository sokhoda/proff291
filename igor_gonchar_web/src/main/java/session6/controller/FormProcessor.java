package session6.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Home on 17.01.2016.
 */

@WebServlet("/form")
public class FormProcessor extends HttpServlet {
    private Map<String, String> mapOpUsers;


    @Override
    public void init() throws ServletException {
        mapOpUsers = new HashMap<>();
        mapOpUsers.put("Igor", "aaa");
        mapOpUsers.put("Tom", "bbb");
        mapOpUsers.put("Vova", "ccc");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("Hello Servlet from /form page");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // String login = request.getParameter("login");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];

        if (mapOpUsers.get(login) != null) {
            if (mapOpUsers.get(login).equals(password)) {
            /*response.getWriter().println("Your login is: " + login);
            response.getWriter().println("Your password is: " + password);*/
                response.getWriter().println("Hello, " + login);
            } else {
                response.getWriter().println("Good bye: " + login);
            }
        } else {
            response.getWriter().println("Good bye: " + login);
        }
    }
}
