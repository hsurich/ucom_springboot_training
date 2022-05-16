package com.uuu.demo.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class SetupEnvironment implements CommandLineRunner {
    ApplicationContext context;

    public SetupEnvironment(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        Calculator calc1 = context.getBean("add", Calculator.class);
        log.info("get calc={}", calc1.calc(5, 6));
        Calculator calc2 = context.getBean("sub", Calculator.class);
        log.info("get calc={}", calc2.calc(6, 6));
    }
}
