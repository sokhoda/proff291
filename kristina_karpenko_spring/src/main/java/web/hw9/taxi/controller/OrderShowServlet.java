package web.hw9.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.hw9.taxi.service.OrderService;
import web.hw9.taxi.service.OrderServiceImpl;

@Controller
public class OrderShowServlet {

    @Autowired
    protected OrderService service = new OrderServiceImpl();

    @RequestMapping(value = "/showOrdersSum", method = RequestMethod.GET)
    public String showOrdersSum(@RequestParam("min") double min, @RequestParam("max") double max, Model model) {
        model.addAttribute("orders", service.showOrdersSum(min, max));
        return "orders";
    }

}
