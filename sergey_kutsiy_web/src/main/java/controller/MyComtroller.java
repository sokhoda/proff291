package controller;

import android.util.Log;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Сергей on 28.02.2016.
 */
@Controller
public class MyComtroller {

    public static final Logger log = Logger.getLogger(MyComtroller.class);

    @RequestMapping(value = "/random.html", method = RequestMethod.GET)

    public @ResponseBody
    String randomGenerator (@RequestParam("login") String name, Model model) {
        int count = (int) (Math.random() * 10);
        log.info("/random.html controller: rendom count = " + count);
    String countStr = Integer.toString(count);
    return "aerae";
}


}