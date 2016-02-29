package hw9.taxi.controller;

import hw9.taxi.service.AuthorizationService;
import hw9.taxi.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 * Created by Вадим on 28.02.2016.
 */

@Controller
public class RegisterServlet {

    @Autowired
    private AuthorizationService service;

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String userRegister(@RequestParam("login") String login,
                               @RequestParam("idNumber") String idNumber,
                               @RequestParam("password") String password,
                               Model model) {
        String msg = "";
        try {
            if (service.register(login, idNumber, password)) {
                msg = "New user added successfully";
            }
        } catch (AuthenticationException e) {
            msg = e.getMessage();
        }
        model.addAttribute("msg", msg);
        return "register";
    }


}
