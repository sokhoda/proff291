package hw9.taxi.controller;

import hw9.taxi.exception.ClientException;
import hw9.taxi.service.ClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

import java.util.List;

import static hw9.taxi.service.AuthorizationServiceImpl.String2Integer;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 3/16/15
 */
@Controller
@SessionAttributes("id")
public class PortionClientServlet {
    public static final Logger log = Logger.getLogger(PortionClientServlet.class);

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/showClientsByPortion.html", method = RequestMethod.GET)
    public String showClientsByPortion(
                               @RequestParam ("listClientsByPortionPortion") String portionSize,
                                      Model model) throws ServletException{
        log.info("/showClientsByPortion.html PortionClientServlet");
        try {
           Integer  sPortion = String2Integer(portionSize);
           Integer totPages = clientService.getClientsTotPages(sPortion);
           List clientList =  clientService.showClientsByPortion(sPortion, 1);

            model.addAttribute("cnt", 1);
            model.addAttribute("totPages", totPages);
            model.addAttribute("clientList", clientList);
            model.addAttribute("sPortion", sPortion);
            return "clients";
        }
        catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }
}
