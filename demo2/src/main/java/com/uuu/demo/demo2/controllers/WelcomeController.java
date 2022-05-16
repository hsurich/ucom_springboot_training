package com.uuu.demo.demo2.controllers;


import com.uuu.demo.demo2.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private Message message;

    @RequestMapping("/welcome")
    public Message welcome() {
        return message;
    }
}
