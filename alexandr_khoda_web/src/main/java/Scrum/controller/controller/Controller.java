package Scrum.controller.controller;

import Scrum.controller.Service.Service;
import Scrum.exception.StringDataException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by s_okhoda on 05.03.2016.
 */
@org.springframework.stereotype.Controller
public class Controller {
    public static final Logger log = Logger.getLogger(Controller.class);

    private Service service;


    @RequestMapping(value = "/estimations.html", method = RequestMethod.GET)
    public String hello(@RequestParam("inputData") String inputData, Model model) {
        log.info("/estimations.html controller");
        String [] arr=null;
        try {
            arr = service.stringToArray(inputData);
            service.sum(arr);
        }
        catch (StringDataException e) {
            model.addAttribute("sum", e.getMessage());
            model.addAttribute("reverse", e.getMessage());
            model.addAttribute("random", e.getMessage());
        }
        model.addAttribute("sum",  service.sum(arr));
        model.addAttribute("reverse", service.revers(arr));
        model.addAttribute("random", service.random(arr));

        return "index";
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index Controller");
        return "index";
    }



}
