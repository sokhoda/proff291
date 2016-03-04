package hw9.taxi.controller;

import hw9.taxi.exception.AuthenticationException;
import hw9.taxi.service.AuthorizationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes("id")
public class RegisterServlet {
    public static final Logger log = Logger.getLogger(RegisterServlet.class);

    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "/back2Menu.html", method = RequestMethod.GET)
    public String back2Menu(Model model) throws ServletException{
        log.info("RegisterServlet /back2Menu.html controller");
        return "dashboard";
    }


    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register() throws ServletException{
        log.info("RegisterServlet /register.html controller");
        return "register";
    }

    @RequestMapping(value = "/doRegister.html", method = RequestMethod.GET)
    public @ResponseBody String doRegister(@RequestParam ("login") String login,
                                         @RequestParam ("identifier") String identifier,
                                         @RequestParam ("pass") String pass,
                                         Model model) throws ServletException {
        log.info("RegisterServlet /doRegister.html controller");
        try {
            if (authorizationService.register(login, identifier, pass)) {
                return "User '" + login + ", " + identifier + "' successfully created.";
            }
            else {
                throw new AuthenticationException("Failed to register user.");
            }
        }
        catch (Exception e){
            throw new ServletException(e.getMessage());
        }
    }

    @RequestMapping(value = "/checkLoginPass.html", method = RequestMethod.GET)
    public String checkLoginPass(@RequestParam ("login") String login,
                                 @RequestParam ("pass") String pass
    ) throws ServletException {
        log.info("RegisterServlet /checkLoginPass.html controller");
        try {
            if (authorizationService.checkLoginPass(login, pass)) {
                return "dashboard";
            }
            else {
                throw new AuthenticationException("No User with such login/pass " +
                        "found.");
            }
        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index() {
        log.info("/index ");
//        model.addAttribute("name", "al1");
//        System.out.println(str);
        return "index";
    }
}
