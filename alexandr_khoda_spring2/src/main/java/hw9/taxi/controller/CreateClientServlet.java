package hw9.taxi.controller;

import hw9.taxi.exception.ClientException;
import hw9.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes("id")
public class CreateClientServlet {
    public static final Logger log = Logger.getLogger(CreateClientServlet.class);

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/createClient.html", method = RequestMethod.GET)
    public @ResponseBody String createClient(@RequestParam ("name") String name,
                                      @RequestParam ("surname") String surname,
                                      @RequestParam ("phone") String phone,
                                      @RequestParam ("address") String address,
                                             Model model) throws ClientException{
        if (clientService.createClient(name, surname, phone, address)){
            return "Client '" + name + ", " + surname + "' successfully created.";
        }
        else {
            throw new ClientException("Failed to create client.");
        }
    }
}
