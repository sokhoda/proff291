package scrum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import scrum.service.ScrumServiceImpl;

import java.util.ArrayList;
import java.util.List;

//import web.service.EmployeeService;
/**
 * Created by Pavel on 05.03.2016.
 */
@Controller
@SessionAttributes("id")
public class ScrumController {

    @Autowired
    ScrumServiceImpl scrumServiceImpl;

    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String hello(@RequestParam("numbers") String number, Model model) {
        List<Integer> numbers = scrumServiceImpl.StringToArray(number);

        if(number != null) {//scrumServiceImpl.arrayToString()
            model.addAttribute("sum", "SDS");
            model.addAttribute("reverse", "SDS");
            model.addAttribute("random", "SDS");
        } else {
            model.addAttribute("sum", "NOT POSSIBLE");
            model.addAttribute("reverse", "NOT POSSIBLE");
            model.addAttribute("random", "NOT POSSIBLE");
        }
        return "index";
    }
}
