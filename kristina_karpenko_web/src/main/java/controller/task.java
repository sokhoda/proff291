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

//пользователь вводит логин пароль. Если пользователь зареген, (инф есть в сервлете) то приведствуем польз по имени
//если не зареген, по пишем "пока..."
@WebServlet("/users")
public class task extends HttpServlet {
    Map<String, String> users = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        users.put("Kostya", "qwerasdf");
        users.put("kris", "12345678");
        users.put("qqq", "aaaa");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String reqLog = req.getParameter("login");
        String reqPas = req.getParameter("password");
        if( users.containsKey(reqLog)&&users.containsValue(reqPas)){
            req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
        }
        else {
            resp.getWriter().print("Error authorization, "+reqLog);
        }


    }
}

