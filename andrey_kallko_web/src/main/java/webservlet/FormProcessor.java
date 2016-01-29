package webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tri___ton on 17.01.16.
 */

@WebServlet("/form")
public class FormProcessor extends HttpServlet {
    HashMap <String, String> users = new HashMap<String,String>();
    String login;
    String pass;

    @Override
    public void init(){
        users.put("Alex", "123");
        users.put("Andy", "456");
        System.out.printf("Добавлено 2 пользователя.");
    }

    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // простой вариант получения параметра
        //login =  request.getParameter("login");



        // надежный вариант получения параметра
        Map<String, String[]> parameterMap = request.getParameterMap();
        login = parameterMap.get("login")[0];
        pass = parameterMap.get("pass")[0];

        System.out.println(users);
        System.out.println(login + " " + pass);

        if ((users.containsKey(login)) && (users.get(login).equals(pass))) {
            response.getWriter().println("Hello " + login+ " from servlet!!!");
        } else {
            response.getWriter().println("Good Bye " + login+ " from servlet!!!");
        }

    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}
