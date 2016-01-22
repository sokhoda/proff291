package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Сергей on 17.01.2016.
 */
@WebServlet("/form")
public class FoemProcessor extends HttpServlet {

    private ArrayList<String> dbList = new ArrayList<>();

    @Override
    public void init(){

    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean isAuth=false;

        /*req.getParameterMap().get("login");
        resp.getWriter().print("Your name " + login );*/
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("Hello anyOne form");
    }

}
