package hw9.taxi.controller;

import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServlet;

@Controller
@SessionAttributes("id")
public class RegisterServlet {
    public static final Logger log = Logger.getLogger(RegisterServlet.class);
    @Autowired
    private AuthorizationService service;
    @Autowired
    private String str;

    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
    public String registrationUser(@RequestParam("login") String login, @RequestParam("idNumber") String idNumber,
                                   @RequestParam("pas") String password, Model model) {

        log.info("/register.html controller");
        try {
            service.register(login, idNumber, password);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println(str);

        return "r";
    }
    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public String hello(@RequestParam("login") String name, Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "hello " + name);
        return "index";
    }
    //===============================================================

}
