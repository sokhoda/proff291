package hw9.controller;


import hw9.domain.Client;
import hw9.domain.Order;
import hw9.service.ClientService;
import hw9.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by i.gonchar on 3/2/2016.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String passwordDataConfirm(@RequestParam("clientId") String clientId, @RequestParam("orderDate") String orderDate,
                                      @RequestParam("fromAddress") String fromAddress, @RequestParam("toAddress") String toAddress, @RequestParam("orderAmount") String orderAmount, Model model) {

        if (findOrerByAddressFromAndTo(fromAddress, toAddress) == null) {
            Double amount = Double.parseDouble(orderAmount);
            Long clientIdParsed = Long.parseLong(clientId);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();

            Client client = clientService.getClientById(clientIdParsed);
            client.setLastOrderDate(date);
            client.updateOrdersAmount(amount);
            clientService.updateClient(client);

            try {
                date = sdf.parse(orderDate);
            } catch (ParseException e) {
            }

            Order order = new Order(date, client, amount, fromAddress, toAddress);
            orderService.createOrder(order);

            List<Order> ordertList = orderService.getAllOrders();
            model.addAttribute("ordertList", ordertList);

            model.addAttribute("reg_result", "Order was added");
            return "addOrder";
        }


        model.addAttribute("reg_result", "Such order already exists");
        return "addOrder";
    }

    private Order findOrerByAddressFromAndTo(String fromAddress, String toAddress) {
        return orderService.getOrderByFromToAddress(fromAddress, toAddress);
    }

}
