package com.uuu.demo.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Order(2)
@Component
public class ValidateBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            log.info("hi, I will execute after spring boot startup");
        }
    }
}
