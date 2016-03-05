package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Сергей on 05.03.2016.
 */
@Controller
public class TeamController {


    public static final Logger log = Logger.getLogger(MyComtroller.class);

    @RequestMapping(value = "/controller.html", method = RequestMethod.GET)

    public String receiveString (@RequestParam("array") String arr, Model model) {

        String summ="null";
        String reverse="null";
        String rnd="null";

        Service srv = new Servise ();
        summ = srv;
        model.addAttribute("summ", summ);
        model.addAttribute("reverse", reverse);
        model.addAttribute("rnd", rnd);


        return "LaTable";
    }


}
