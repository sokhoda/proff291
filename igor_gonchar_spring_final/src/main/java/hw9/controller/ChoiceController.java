package hw9.controller;

import hw9.domain.Client;
import hw9.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by i.gonchar on 3/3/2016.
 */
@Controller
public class ChoiceController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/choiceSelector", method = RequestMethod.POST, params = {"addButton"})
    public String addChoice(@RequestParam("addOption") String option, @RequestParam String addButton) {

        if (option.equals("client")) {
            return "addClient";
        }
        return "addOrder";
    }

    @RequestMapping(value = "/choiceSelector", method = RequestMethod.POST, params = {"editButton"})
    public String editChoice(@RequestParam("addOption") String option, @RequestParam String editButton, Model model) {

        if (option.equals("client")) {
            List<Client> clientList = clientService.getAllClients();
            model.addAttribute("clientList", clientList);

            return "editClient";
        }
        return "editOrder";
    }

    @RequestMapping(value = "/choiceSelector", method = RequestMethod.POST, params = {"showButton"})
    public String showChoice(@RequestParam("addOption") String option, @RequestParam String showButton, Model model) {
        String res = "";

        if (option.equals("client")) {
            res = "client show";
        } else {
            res = "order show";
        }

        model.addAttribute("choice_res", res);
        return "choicePage";
    }

    @RequestMapping(value = "/choicePage", method = RequestMethod.GET)
    public String choicePage() {
        return "choicePage";
    }
}
