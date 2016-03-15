package web.hw9.taxi.controller;

import org.springframework.web.bind.annotation.*;

import web.hw9.taxi.exception.AuthenticationException;
import web.hw9.taxi.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.hw9.taxi.service.AuthorizationServiceImpl;


@Controller
public class RegisterServlet {
    public static final Logger log = Logger.getLogger(RegisterServlet.class);
    @Autowired
    private AuthorizationService service = new AuthorizationServiceImpl();
    @Autowired
    private String str;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String toHome() {
        return "dashboard";

    }


    @RequestMapping(value = "/islogin.html", method = RequestMethod.GET)
    public
    @ResponseBody
    String isLogin(@RequestParam("login") String login) {
        if (!service.isLogin(login)) {
            return "Choose another login!!!";
        }
        return "This login is free." ;
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(@RequestParam("login") String login, @RequestParam("pas") String password, Model model) {


        if (login == "" || password == "") {
            model.addAttribute("error", "Fill all fields!");
            return "index";
        }
        if (service.isUser(login, password)) {
            model.addAttribute("message", "Welcome, " + login);
        } else {
            model.addAttribute("error", "Invalid login. Try Again");
            return "index";
        }
        return "dashboard";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration() {
        return "registerUser";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registrationUser(@RequestParam("login") String login, @RequestParam("idNumber") String idNumber,
                                   @RequestParam("pas") String password, Model model) {

        try {
            if (login == "" || idNumber == "" || password == "") {
                model.addAttribute("message", "Fill all fields!");
                return "register";
            }
            if (service.register(login, idNumber, password)) {
                model.addAttribute("message", "Registration succesfull");
            } else {
                model.addAttribute("error", "Registration is not succesfull. Try Again");
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            model.addAttribute("message", "Registration is not succesfull. Try Again");
        }
        return "dashboard";
    }


    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index controller");
        model.addAttribute("name", "al1");
        System.out.println(str);
        return "index";
    }

    @RequestMapping(value = "/hello.html", method = RequestMethod.GET)
    public String hello(@RequestParam("login") String name, Model model) {
        log.info("/hello.html controller");
        model.addAttribute("name", "hello " + name);
        return "index";
    }
    //===============================================================

}
