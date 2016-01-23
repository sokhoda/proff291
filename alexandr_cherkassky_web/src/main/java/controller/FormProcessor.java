package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Пк2 on 17.01.2016.
 */
@WebServlet("/x.html")      // Псевдоним сервлета символическое имя сервлета.Пользователь не должен знать истинного имя сервлета безопасность
public class FormProcessor extends HttpServlet {
    static Map<String, String > users =new HashMap<>();

    public void init(ServletConfig Config) throws ServletException{
         users.put("Sveta", "123");
         users.put("Pavel","456");

    }

    Iterator Map.Entry<String, String>> iter= users.entrySet().iterator();
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
//        String login = request.getParameter("login");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        response.getWriter().print("Your name is " + login);
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("Hello servlet");
    }


    }


