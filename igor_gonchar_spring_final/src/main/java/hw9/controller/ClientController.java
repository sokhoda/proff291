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
 * Created by i.gonchar on 3/2/2016.
 */
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private String str;

    @RequestMapping(value = "/addClient", method = RequestMethod.POST)
    public String passwordDataConfirm(@RequestParam("clientName") String clientName, @RequestParam("clientSurname") String clientSurname,
                                      @RequestParam("clientPhone") String clientPhone, @RequestParam("clientAddress") String clientAddress, Model model) {

        if (findClientByNameAndPhone(clientName, clientPhone) == null) {
            Client client = new Client(clientName, clientSurname, clientPhone, clientAddress);
            clientService.createClient(client);
            model.addAttribute("reg_result", clientName + " was registered");
            return "addClient";
        }

        model.addAttribute("reg_result", "Client with such name: " + clientName + " and phone: " + clientPhone + " already exists");
        return "addClient";
    }

    private Client findClientByNameAndPhone(String clientName, String clientPhone) {
        return clientService.getClientByNameAndPhone(clientName, clientPhone);
    }

    @RequestMapping(value = "/editClient", method = RequestMethod.POST)
    public String editClient() {
       /* List<Client> clientList = clientService.getAllClients();
        model.addAttribute("clientList", clientList);*/
        return "editClient";
    }
}