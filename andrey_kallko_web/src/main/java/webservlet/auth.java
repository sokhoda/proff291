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
 * Created by elenabugercuk on 21.01.16.
 */
@WebServlet("/auth")
public class auth extends HttpServlet {
        HashMap<String, String> admin = new HashMap<String,String>();
        String login;
        String pass;

    @Override
    public void init(){
        admin.put("Alex", "123");
        admin.put("Andy", "456");
        System.out.println("Добавлено 2 admina");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // простой вариант получения параметра
        //login =  request.getParameter("login");


        // надежный вариант получения параметра
        Map<String, String[]> parameterMap = request.getParameterMap();
        String tempname = parameterMap.get("name")[0];
        String temppass = parameterMap.get("pass")[0];

        if ((admin.containsKey(tempname))&&(admin.get(tempname).equals(temppass))){
            request.getRequestDispatcher("dashboard.jsp").forward(request,response);
        } else {
            System.out.println("Пароль неправильный");
            response.getWriter().println("Введите корректный логин/пароль ");
            request.getRequestDispatcher("oldindex.jsp").forward(request,response);
        }
    }

}

