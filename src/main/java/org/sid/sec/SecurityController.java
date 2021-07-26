package org.sid.sec;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SecurityController {
    @RequestMapping(value="/login")
    public String login(){
        return "login3";
    }
    @RequestMapping(value="/")
    public String home(){

        return "redirect:/home";
    }
    @RequestMapping(value="/403")
    public String accessDenied(){
        return "403";
    }
}

