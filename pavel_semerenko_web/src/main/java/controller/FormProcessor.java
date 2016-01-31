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
 * Created by Pavel on 17.01.2016.
 */
@WebServlet("/form")
public class FormProcessor extends HttpServlet{
    Map<String, String> users = new HashMap<>();

    @Override
    public void init() throws ServletException {
        users.put("Victor", "pass");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String login = parameterMap.get("login")[0];
        if(users.get(login) != null){
            resp.getWriter().print("Hi, " + login);
        } else {
            resp.getWriter().print("Good buy, stranger!");
        }
    }
}
