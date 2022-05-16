package com.uuu.demo.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@Slf4j
public class PrepareDatabase implements CommandLineRunner {
    @Autowired
    ApplicationContext context;

    @Bean(name = "mul")
    Calculator getCalculator() {
        return new MulCalculator();
    }

    @Override
    public void run(String... args) throws Exception {
        Calculator calcP = context.getBean("mul", Calculator.class);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            //log.info("I will setup database here...with i=" + i);
            log.info("using calcp to calculate i+1*i+2={}", calcP.calc(i + 1, i + 2));
        }
    }
}
