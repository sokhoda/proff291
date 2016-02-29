package hw9.controller;

import hw9.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by i.gonchar on 2/29/2016.
 */
@Controller
@SessionAttributes("id")
public class UserController {
    public static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private String str;
}
