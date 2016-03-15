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
public class OrderShowPortionServlet {
    @Autowired
    protected OrderService service = new OrderServiceImpl();
    int page;
    int portSize;

    @RequestMapping(value = "/showPortionOrder0", method = RequestMethod.GET)
    public String showPortionOrder(@RequestParam("portSize") int portSize, Model model){
        this.portSize = portSize; this.page =1;
        model.addAttribute("orders",service.showOrdersByPortion(page,portSize));
        model.addAttribute("port",1);
        return "orders";
    }

    @RequestMapping(value = "/showPortionOrderNext", method = RequestMethod.GET)
    public String showPortionOrderNext(Model model){
        model.addAttribute("orders",service.showOrdersByPortion(++page,portSize));
        model.addAttribute("port",1);
        return "orders";
    }


    @RequestMapping(value = "/showPortionOrderPrev", method = RequestMethod.GET)
    public String showPortionOrderPrev(Model model){
        model.addAttribute("orders",service.showOrdersByPortion(--page,portSize));
        model.addAttribute("port",1);
        return "orders";
    }
}
