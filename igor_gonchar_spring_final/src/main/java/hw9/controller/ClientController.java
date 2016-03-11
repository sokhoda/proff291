package hw9.controller;

import hw9.domain.Client;
import hw9.service.ClientService;
import hw9.utils.FileUtils;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @RequestMapping(value = "/editClient", method = RequestMethod.POST, params = {"editButton"})
    public String editClient(@RequestParam("clientId") Long clientId, @RequestParam("clientName") String clientName, @RequestParam("clientSurname") String clientSurname,
                             @RequestParam("clientPhone") String clientPhone, @RequestParam("clientAddress") String clientAddress, Model model) {

        Client client = clientService.getClientById(clientId);
        if (clientName != null && !clientName.equals("")) {
            client.setName(clientName);
        }
        if (clientSurname != null && !clientSurname.equals("")) {
            client.setSurname(clientSurname);
        }
        if (clientPhone != null && !clientPhone.equals("")) {
            client.setTelephone(clientPhone);
        }
        if (clientAddress != null && !clientAddress.equals("")) {
            client.setAddress(clientAddress);
        }

        clientService.updateClient(client);

        List<Client> clientList = clientService.getAllClients();
        model.addAttribute("clientList", clientList);

        model.addAttribute("edit_result", "Client was edited");
        return "editClient";
    }

    @RequestMapping(value = "/editClient", method = RequestMethod.POST, params = {"deleteButton"})
    public String deleteClient(@RequestParam("clientId") Long clientId, Model model) {

        Client client = clientService.getClientById(clientId);
        clientService.removeClient(client);

        List<Client> clientList = clientService.getAllClients();
        model.addAttribute("clientList", clientList);

        model.addAttribute("edit_result", "Client was deleted");

        return "editClient";
    }


    @RequestMapping(value = "/addMassClient", method = RequestMethod.POST)
    public String editMassClient(@RequestParam("addClientPath") String addClientPath, Model model) {

        List<Client> clientFromFile = FileUtils.clientMassEditResult(addClientPath);
        if (clientFromFile != null) {
            for (Client client : clientFromFile) {
                clientService.createClient(client);
            }
        }
        return "addClient";
    }
}
