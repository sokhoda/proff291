package web.hw9.taxi.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.hw9.taxi.exception.OrderException;
import web.hw9.taxi.service.ClientService;
import web.hw9.taxi.service.ClientServiceImpl;


@Controller
public class CreateClientServlet {

    public static final Logger log = Logger.getLogger(RegisterServlet.class);
    @Autowired
    private ClientService service = new ClientServiceImpl();
    @Autowired
    private String str;

    @RequestMapping(value = "/registerClient", method = RequestMethod.GET)
    public String registrationClient() {
        return "registerClient";
    }

    @RequestMapping(value = "/registerClient", method = RequestMethod.POST)
    public String registerClient(@RequestParam("name") String name, @RequestParam("surName") String surName, @RequestParam("phone") String phone,
                                @RequestParam("address") String address, Model model) {
        try {
            service.createClient(name, surName, phone, address);
            model.addAttribute("ClientMessage","Creation of client was successful");
        } catch (OrderException e) {
            e.printStackTrace();
            model.addAttribute("ClientMessage","Creation of client was NOT successful. Try Again.");
            return "registerClient";
        }
        return "dashboard";
    }
}
