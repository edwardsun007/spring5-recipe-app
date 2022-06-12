package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jt on 6/1/17.
 */
@Controller
public class aboutController {

    @RequestMapping({"/about"})
    public String getAboutPage(){

        return "aboutMe";
    }
}
