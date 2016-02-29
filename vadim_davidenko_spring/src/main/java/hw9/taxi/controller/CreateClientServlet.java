package hw9.taxi.controller;

import hw9.taxi.exception.ClientException;
import hw9.taxi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

/**
 * Created by Вадим on 28.02.2016.
 */

@Controller
public class CreateClientServlet extends HttpServlet {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "/registerClient.html", method = RequestMethod.GET)
    public String clientRegister(@RequestParam("firstName") String name,
                               @RequestParam("lastName") String surname,
                               @RequestParam("phone") String phone,
                               @RequestParam("address") String address,
                               Model model) {
        String msg = "";
        try {
            if (service.createClient(name, surname, phone, address)) {
                msg = "New client added successfully";
            }
        } catch (ClientException e) {
            msg = e.getMessage();
        }
        model.addAttribute("msg", msg);
        return "registerClient";
    }
}
