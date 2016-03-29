package web.hw9.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.hw9.taxi.service.ClientService;
import web.hw9.taxi.service.ClientServiceImpl;

@Controller
public class PortionClientServlet {
    int portSize;
    int page;
    @Autowired
    ClientService clientService = new ClientServiceImpl();

    @RequestMapping(value = "/portion0", method = RequestMethod.GET)
    public String showByPortion0(@RequestParam("portSize") int portSize,  Model model) {
        this.portSize=portSize; page = 1;
        model.addAttribute("client",clientService.showClientsByPortion(page,portSize));
        model.addAttribute("port",1);
        return "clients";
    }

    @RequestMapping(value = "/portionNext", method = RequestMethod.GET)
    public String showByPortionNex(  Model model) {
        model.addAttribute("client",clientService.showClientsByPortion(++page,portSize));
        model.addAttribute("port",1);

        return "clients";
    }

    @RequestMapping(value = "/portionPrev", method = RequestMethod.GET)
    public String showByPortionPrev(  Model model) {
        model.addAttribute("client",clientService.showClientsByPortion(--page,portSize));
        model.addAttribute("port",1);
        return "clients";
    }

}