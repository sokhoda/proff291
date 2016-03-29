package web.hw9.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.hw9.taxi.service.ClientService;
import web.hw9.taxi.service.ClientServiceImpl;

@Controller
public class MonthClientServlet {

    @Autowired
    ClientService clientService = new ClientServiceImpl();

    @RequestMapping(value = "/showClientMonth", method = RequestMethod.GET)
    public String showByPortionNex(  Model model) {
        model.addAttribute("client",clientService.showClientsLastMonth());
        return "clients";
    }
}
