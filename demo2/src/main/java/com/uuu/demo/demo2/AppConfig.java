package com.uuu.demo.demo2;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfig
{
    //@Bean (name="add")
    @Bean
    Calculator cal1() {
        log.info("create a bean with type Calculator");
        return new AddCalculator();
    }

    //@Bean (name="sub")
    @Bean
    Calculator cal2() {
        return new SubCalculator();
    }
}
