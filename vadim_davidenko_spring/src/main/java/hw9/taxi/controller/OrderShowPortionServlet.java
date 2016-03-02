package hw9.taxi.controller;

import hw9.taxi.domain.Order;
import hw9.taxi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Вадим on 28.02.2016.
 */

@Controller
@SuppressWarnings("unchecked")
public class OrderShowPortionServlet {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders/ByPortion")
    public String showByPortion(Model model) {
        List<Order> orders = (List<Order>) orderService.showOrdersByPortion(0);
        model.addAttribute("orderList", orders);
        return "orders";
    }

    @RequestMapping(value = "/reportByPortion/{direction}")
    public String reportPaging(Model model, @PathVariable Integer direction) {
        final int PORTION_SIZE = 5;
        List<Order> orders = (List<Order>) orderService.showOrdersByPortion(PORTION_SIZE * direction);
        model.addAttribute("orderList", orders);
        return "orders";
    }
}
