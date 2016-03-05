package scrum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
jj
//import web.service.EmployeeService;
/**
 * Created by Pavel on 05.03.2016.
 */
@Controller
@SessionAttributes("id")
public class ScrumController {


    @RequestMapping(value = "/calc", method = RequestMethod.GET)
    public String hello(@RequestParam("numbers") String number, Model model) {
       // log.info("/hello.html controller");
        model.addAttribute("sum", "hello " + number);
        model.addAttribute("reverse", "hello " + number);
        model.addAttribute("random", "hello " + number);
        return "index";
    }
}
