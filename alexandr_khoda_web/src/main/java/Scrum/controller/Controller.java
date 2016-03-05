package Scrum.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by s_okhoda on 05.03.2016.
 */
@org.springframework.stereotype.Controller
@SessionAttributes("controller")
public class Controller {
    public static final Logger log = Logger.getLogger(Controller.class);


    @RequestMapping(value = "/Estimations.html", method = RequestMethod.GET)
    public String hello(@RequestParam("sum") String sum, @RequestParam("reverse")  String reverse, @RequestParam("random") String rand, Model model) {
        log.info("/hello.html controller");
        model.addAttribute("sum" + sum);
        model.addAttribute("reverse"+reverse);
        model.addAttribute("random"+rand);

        return "index";
    }

}
