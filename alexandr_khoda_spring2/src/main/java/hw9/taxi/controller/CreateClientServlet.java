package hw9.taxi.controller;

import hw9.taxi.domain.MessageResult;
import hw9.taxi.exception.ClientException;
import hw9.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@EnableWebMvc
@SessionAttributes("id")
public class CreateClientServlet {
    public static final Logger log = Logger.getLogger(CreateClientServlet.class);

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/createClient.json", method = RequestMethod.GET,
            produces = "application/json")
    public @ResponseBody
    MessageResult createClient(@RequestParam ("name") String name,
                    @RequestParam ("surname") String surname,
                    @RequestParam ("phone") String phone,
                    @RequestParam ("address") String address, Model model) {
        log.info("CreateClientServlet /createClient.json controller");
        try {
            if (clientService.createClient(name, surname, phone, address)) {
                return new MessageResult("Client '" + name + ", " + surname + "' successfully created.", "green");
            }
            else {
                throw new ClientException("Failed to create client.");
            }
        }
        catch (Exception e){
            return new MessageResult(e.getMessage(), "red");
        }
    }

    @RequestMapping(value = "/registerClient.html", method = RequestMethod.GET)
    public String registerClient() {
        log.info("CreateClientServlet /registerClient.html controller");
        return "registerClient";
    }
}
