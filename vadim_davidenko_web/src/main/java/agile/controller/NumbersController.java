package agile.controller;

import agile.service.NumberService;
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
 * Created by Вадим on 05.03.2016.
 */

@Controller
public class NumbersController {
    public static final Logger log = Logger.getLogger(NumbersController.class);

    @Autowired
    private NumberService numberService;

    @Autowired
    private String str;

    @RequestMapping(value = "/numberController", method = RequestMethod.POST)
    public String passwordDataConfirm(@RequestParam("inp") String inp, Model model) {
        if (inputValidation(inp)) {
            Double result = numberService.calculateSum(inp);
            String result1 = result.toString();
            String result2 = numberService.reverse(inp);
            String result3 = numberService.shuffle(inp);

            model.addAttribute("res1", result1);
            model.addAttribute("res2", result2);
            model.addAttribute("res3", result3);
            return "index";
        }
        model.addAttribute("res1", "Incorrect data entered");
        return "index";
    }

    private boolean inputValidation(String input) {
        Pattern p = Pattern.compile("\\D+");
        Matcher m = p.matcher(input);
        if (m.find()) {
            return false;
        }
        /*String[] inp = input.split(" ");
        int arrLength = inp.length;
        int inputLength = input.length();
        if (inputLength / arrLength == 2) {
            return true;
        }*/
        return true;
    }
}
