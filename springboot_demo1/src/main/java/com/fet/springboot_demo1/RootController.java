package com.fet.springboot_demo1;

import com.fet.springboot_demo1.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hi, Fet with Spring Boot");
        return "home";
    }

    @Autowired
    private GreetingService service;

    @RequestMapping("/greeting")
    public @ResponseBody String greeting() {
        return service.greet();
    }
}
