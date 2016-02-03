package hw8.taxi.action;

import hw8.taxi.domain.Client;
import hw8.taxi.service.ClientService;

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

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet{

    Map<String, String> users = new HashMap<String, String>();

    ClientService clientService= new ClientService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        resp.getWriter().println("Hello servlet1");

    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        Map<String, String []> paramMap = req.getParameterMap();
        try {
          String tmp = paramMap.get("login")[0];
        } catch (NullPointerException e){
            if (paramMap.get("name")[0] != null) {
                String name = paramMap.get("name")[0];
                String surname = paramMap.get("surname")[0];
                String numberOfPhone = paramMap.get("numberOfPhone")[0];
                String address = paramMap.get("address")[0];
                if (name.equals("") || surname.equals("") || numberOfPhone.equals("") || address.equals("")) {
                    req.setAttribute("result", "Error: password or login");
                    req.getRequestDispatcher("registerClient.jsp").forward(req, res);
                } else {
                    clientService.clients.add(new Client(name, surname, numberOfPhone, address));
                    req.setAttribute("result", "Client Add To Base");
                    req.getRequestDispatcher("dashboard.jsp").forward(req, res);
                }
            }
        }
        if(paramMap.get("login")[0] != null) {
            String login = paramMap.get("login")[0];
            String password = paramMap.get("password")[0];

            if (login.equals("admin") == true && password.equals("admin") == true) {
                req.getRequestDispatcher("dashboard.jsp").forward(req, res);
            } else {
                req.setAttribute("result", "Error: password or login");
                req.getRequestDispatcher("taxiMain.jsp").forward(req, res);

            }
        }


        }



 }
