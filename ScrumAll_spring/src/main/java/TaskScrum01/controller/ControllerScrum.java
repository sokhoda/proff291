package TaskScrum01.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by s_okhoda on 05.03.2016.
 */
@org.springframework.stereotype.Controller
public class ControllerScrum {
    public static final Logger log = Logger.getLogger(ControllerScrum.class);

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String index(Model model) {
        log.info("/index Controller");
        return "index";
    }



}
