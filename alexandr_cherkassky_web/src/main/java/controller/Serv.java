package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Пк2 on 17.01.2016.
 */
@WebServlet("/form")      // Псевдоним сервлета символическое имя сервлета.Пользователь не должен знать истинного имя сервлета безопасность
public class Serv extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        resp.getWriter().println("Hello Servlet");
    }

}
