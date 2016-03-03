package hw9.controller;

import hw9.domain.User;
import hw9.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by i.gonchar on 3/1/2016.
 */
@Controller
public class MenuController {
    public static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private String str;

    @RequestMapping(value = "/registerPage", method = RequestMethod.GET)
    public String registerPage() {
        return "registerPage";
    }

    @RequestMapping(value = "/indexPage", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value = "/loginConfirm", method = RequestMethod.POST)
    public String loginDataConfirm(@RequestParam("login") String login, @RequestParam("password") String password, Model model){
        if(findUserByLoginAndPassword(login, password) == null){
            model.addAttribute("login_result", "No such registered user");
            return "index";
        }

        model.addAttribute("login_result", "Welcome, " + login);
        return "orderPage";
    }

    private User findUserByLoginAndPassword(String login, String password){
        return userService.getUserByLoginAndPassword(login, password);
    }
}
