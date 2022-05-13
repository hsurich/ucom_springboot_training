package com.fet.springboot_demo1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping(value = "/hello")
    public String ping() {
        return "pong";
    }
}