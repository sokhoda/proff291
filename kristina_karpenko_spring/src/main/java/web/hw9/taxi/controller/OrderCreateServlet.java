package web.hw9.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.hw9.taxi.exception.OrderException;
import web.hw9.taxi.service.ClientService;
import web.hw9.taxi.service.ClientServiceImpl;
import web.hw9.taxi.service.OrderService;
import web.hw9.taxi.service.OrderServiceImpl;
import web.hw9.taxi.domain.Client;

import java.util.HashMap;
import java.util.Map;

@Controller
public class OrderCreateServlet {

    @Autowired
    private OrderService service = new OrderServiceImpl();

    @Autowired
    @Qualifier("clientService")
    private ClientService serviceClient = new ClientServiceImpl();


    @RequestMapping(value = "orderCreate", method = RequestMethod.GET)
    public String goToOrder() {
        return "order";
    }

    @RequestMapping(value = "orderCreate", method = RequestMethod.POST)
    public String createOrder(@RequestParam("phone") String phone, @RequestParam("addressFrom") String addressFrom,
                              @RequestParam("addressTo") String addressTo, @RequestParam("sum") String sum,
                              Model model) {
        Map<String, String> modelMap = new HashMap<>();
        modelMap.put("phone", phone);
        modelMap.put("addressFrom", addressFrom);
        modelMap.put("addressTo", addressTo);
        modelMap.put("sum", sum);


        Client client = serviceClient.findClientByPhone(phone);
        if (sum == "") {
            model.addAttribute("order", "Fill all fields!!!");
            model.addAllAttributes(modelMap);
            return "order";
        }
        if (client != null) {
            try {
                serviceClient.addAmount(client, Double.parseDouble(sum));
                service.createOrder(client, Double.parseDouble(sum), addressFrom, addressTo);

                model.addAttribute("order", "Order create successful");
                return "dashboard";
            } catch (OrderException e) {
                System.err.print("Cannot create Order");
            }
        } else {
            System.err.print("Client not exist");
            model.addAttribute("order", "Client not exist. Enter valid phone Number");
        }
        model.addAllAttributes(modelMap);
        return "order";
    }
}


