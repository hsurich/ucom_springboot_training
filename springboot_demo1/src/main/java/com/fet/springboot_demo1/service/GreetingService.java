package com.fet.springboot_demo1.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String greet() {
        return "Hello! This is a spring boot service";
    }
}
