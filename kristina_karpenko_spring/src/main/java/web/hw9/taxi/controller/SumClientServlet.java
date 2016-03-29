package web.hw9.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.hw9.taxi.service.AuthorizationService;
import web.hw9.taxi.service.AuthorizationServiceImpl;
import web.hw9.taxi.service.ClientService;
import web.hw9.taxi.service.ClientServiceImpl;

@Controller
public class SumClientServlet {
    @Autowired
    ClientService clientService = new ClientServiceImpl();

    @RequestMapping(value = "/showClientSum", method = RequestMethod.GET)
    public String showByPortion0(@RequestParam("sum") double sum, Model model) {
        model.addAttribute("client",clientService.showClientsGtSum(sum));
        return "clients";
    }
}
