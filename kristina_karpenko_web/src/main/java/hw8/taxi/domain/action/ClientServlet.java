package hw8.taxi.domain.action;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.exception.ClientException;
import hw8.taxi.domain.servise.ClientService;
import hw8.taxi.domain.servise.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        ClientServiceImpl clientService = new ClientServiceImpl();
        try {
            clientService.createClient(name, surName, phone, address);
            resp.getWriter().print("Successful!!!");
        } catch (ClientException e) {
            resp.getWriter().print("Error Registration");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientServiceImpl clientService = new ClientServiceImpl();
        String portionSize = req.getParameter("portionSize");//Integer.parseInt(
        String portion = req.getParameter("portion");
        String ClientsGtSum = req.getParameter("ClientsGtSum");
        String ClientsSum = req.getParameter("ClientsSum");
        String ClientsLastMonth = req.getParameter("ClientsLastMonth");
        String reg = req.getParameter("registration");
        if (reg != null) {
            req.getRequestDispatcher("registerClient.jsp").forward(req,resp);
        }
        if (portion != null) {
            List<Client> clients = new ArrayList<>(clientService.showClientsByPortion(Integer.parseInt(portionSize)));
            resp.getWriter().print(clients);
        }

        if (ClientsSum != null) {
            List<Client> clients = new ArrayList<>(clientService.showClientsGtSum(Integer.parseInt(ClientsGtSum)));
            resp.getWriter().print(clients);
        }

        if (ClientsLastMonth != null) {
            List<Client> clients = new ArrayList<>(clientService.showClientsLastMonth());
            resp.getWriter().print(clients);
        }

    }
}