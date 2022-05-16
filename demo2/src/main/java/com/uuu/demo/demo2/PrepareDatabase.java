package com.uuu.demo.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Slf4j
public class PrepareDatabase implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            log.info("I will setup database here...with i=" + i);
        }
    }
}
