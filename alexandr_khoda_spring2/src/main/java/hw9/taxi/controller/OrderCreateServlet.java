package hw9.taxi.controller;

import hw9.taxi.domain.Client;
import hw9.taxi.exception.OrderException;
import hw9.taxi.service.ClientService;
import hw9.taxi.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static hw9.taxi.service.AuthorizationServiceImpl.String2Double;
import static hw9.taxi.service.AuthorizationServiceImpl.String2Long;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes("id")
public class OrderCreateServlet {
    public static final Logger log = Logger.getLogger(OrderCreateServlet.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/createOrder.html", method = RequestMethod.GET)
    public @ResponseBody String createOrder(
            @RequestParam ("clientID") String clientID,
            @RequestParam ("amount") String amount,
            @RequestParam ("addressFrom") String addressFrom,
            @RequestParam ("addressTo") String addressTo, Model model) throws
            OrderException{

        Client client = clientService.read(String2Long(clientID));
        if (orderService.createOrder(client, String2Double(amount), addressFrom,
                addressTo)){
            return "Order '" + client.getName() + ", " + amount + ", " + addressFrom
                    + ", " + addressTo + "' successfully created.";
        }
        else {
            return "Failed to create order.";
        }
    }


}
