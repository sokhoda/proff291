package hw8.taxi.action;

import hw8.taxi.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Admin on 20.01.2016.
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    Map<String, String> users = new HashMap<String, String>();

    ClientServiceImpl clientServiceImplements = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.getWriter().println("Hello servlet1");

    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        Map<String, String []> paramMap = req.getParameterMap();

        String login = paramMap.get("login")[0];
        String password = paramMap.get("password")[0];

        if(login.equals("admin") ==  true && password.equals("admin") == true){
            req.getRequestDispatcher("dashboard.jsp").forward(req, res);
        } else{
            req.setAttribute("result", "Error: password or login");
            req.getRequestDispatcher("taxiMain.jsp").forward(req, res);

        }


    }

}
