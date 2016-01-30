package hw8.taxi.domain.action;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.domain.exception.OrderException;
import hw8.taxi.domain.servise.ClientServiceImpl;
import hw8.taxi.domain.servise.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        String amount = req.getParameter("amount");
        String addressFrom = req.getParameter("addressFrom");
        String addressTo = req.getParameter("addressTo");
        String chekOut = req.getParameter("Сheckout");
        String edit = req.getParameter("Edit");

        OrderServiceImpl orderService = new OrderServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();
        List<Client> client = new ArrayList<>(clientService.getClients());
        if (chekOut != null) {
            for (Client cl : client) {
                if (cl.getName().equals(name) && cl.getSurName().equals(surName)) {
                    try {
                        orderService.createOrder(Long.parseLong(date), cl, amount, addressFrom, addressTo);
                        resp.getWriter().print("Successfully!");
                    } catch (OrderException e) {
                        resp.getWriter().print("Error Registration");
                    }
                } else {
                    resp.getWriter().print("Error Registration");
                }
            }
        }
        if (edit != null) {
            for (Client cl : client) {
                if (cl.getName().equals(name) && cl.getSurName().equals(surName)) {
                    orderService.editOrder(Long.parseLong(date), cl, amount, addressFrom, addressTo);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order = req.getParameter("order");
        String edit = req.getParameter("edit");
        String date = req.getParameter("date");
        String name = req.getParameter("name");
        String surName = req.getParameter("surName");
        String amount = req.getParameter("amount");
        String addressFrom = req.getParameter("addressFrom");
        String addressTo = req.getParameter("addressTo");
        String orderSumFrom = req.getParameter("orderSumFrom");
        String orderSumTo = req.getParameter("orderSumTo");
        String OrderSum = req.getParameter("OrderSum");
        String allOrder = req.getParameter("allOrder");
        OrderServiceImpl orderService = new OrderServiceImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();
        if (order != null) {
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        }
        if (edit != null) {
            req.getRequestDispatcher("order.jsp").forward(req, resp);
        }
        if (OrderSum != null) {
            orderService.showOrders(Long.parseLong(orderSumFrom), Long.parseLong(orderSumTo));
        }
        if (allOrder != null) {
            orderService.getOrders();
        }
    }
}