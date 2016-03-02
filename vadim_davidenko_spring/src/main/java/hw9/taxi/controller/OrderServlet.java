package hw9.taxi.controller;

import hw9.taxi.domain.Order;
import hw9.taxi.exception.OrderException;
import hw9.taxi.service.ClientService;
import hw9.taxi.domain.Client;
import hw9.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.NestingKind;
import java.util.List;

/**
 * Created by Вадим on 28.02.2016.
 */

@Controller
@SuppressWarnings("unchecked")
public class OrderServlet {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/order/add")
    public String orderAdd(Model model) {
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        model.addAttribute("order", new Order());

        return "order";
    }

    @RequestMapping(value = "/order/edit/{id}")
    public String orderEdit(Model model, @PathVariable Long id) {
        Order order = orderService.findOrderById(id);
        if (order == null) {
            order = new Order();
            model.addAttribute("msg", "No orders found!");
        }
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("clients", clients);
        model.addAttribute("order", order);

        return "order";
    }

    @RequestMapping(value = "/order/save", method = RequestMethod.POST)
    public String orderSave(Model model, @ModelAttribute("order") Order order, Errors errors){
        String msg = "";
        if (order.getId() != null) {
            // edit
            Client client = clientService.findClientById(order.getClient().getId());
            orderService.editOrder(order.getId(), client, String.valueOf(order.getAmount()),
                        order.getAddressFrom(), order.getAddressTo());
            msg = "Order data saved successfully";
        } else {
            // new
            try {
                if (orderService.createOrder(order.getClient(), order.getAmount(),
                        order.getAddressFrom(), order.getAddressTo())) {
                    msg = "New order added successfully";
                }
            } catch (OrderException e) {
                msg = e.getMessage();
            }
        }
        List<Client> clients = clientService.findAllClients();
        model.addAttribute("order", order);
        model.addAttribute("clients", clients);
        model.addAttribute("msg", msg);

        return "order";
    }
}
