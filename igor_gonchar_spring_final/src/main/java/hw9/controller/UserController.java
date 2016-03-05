package hw9.controller;

import hw9.domain.User;
import hw9.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by i.gonchar on 2/29/2016.
 */
@Controller
//@SessionAttributes("id")
public class UserController {
    public static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private String str;

    @RequestMapping(value = "/passwordDataConfirm", method = RequestMethod.POST)
    public String passwordDataConfirm(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("rePassword") String rePassword, @RequestParam("idNumber") String idNumber, Model model) {
        boolean isIdNumbValidated = idNumberValidation(idNumber);
        boolean isLoginValidated = loginValidation(login);
        boolean isPasswordValidated = passwordValidation(password);

        if (isIdNumbValidated && isLoginValidated && isPasswordValidated) {

            if(findUserByLogin(login) == null){
                int idNumberCasted = Integer.parseInt(idNumber);
                User user = new User(login, password, idNumberCasted);
                userService.createUser(user);

                model.addAttribute("reg_result", login + " was registered");
                return "index";
            }
            model.addAttribute("reg_result", "User with such login: " + login + " already exists");
            return "registerPage";
        }
        model.addAttribute("reg_result", "Please refer to data requirements");
        return "registerPage";
    }

    private boolean passwordValidation(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    private boolean loginValidation(String login) {
        Pattern p = Pattern.compile("\\s+");
        Matcher m = p.matcher(login);
        if (m.find()) {
            return false;
        }
        if (login.length() < 4) {
            return false;
        }
        return true;
    }

    private boolean idNumberValidation(String idNumber) {
        Pattern p = Pattern.compile("\\D+");
        Matcher m = p.matcher(idNumber);
        if (m.find()) {
            return false;
        }
        if (idNumber.length() != 10) {
            return false;
        }
        return true;
    }

    private User findUserByLogin(String login){
        return userService.getUserByLogin(login);
    }
}
