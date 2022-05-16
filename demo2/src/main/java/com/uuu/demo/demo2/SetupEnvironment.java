package com.uuu.demo.demo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@Slf4j
public class SetupEnvironment implements CommandLineRunner {
//    ApplicationContext context;
//
//    public SetupEnvironment(ApplicationContext context) {
//        this.context = context;
//    }

//    @Autowired
//    @Qualifier("add")
//    private Calculator calcx;
//    @Autowired
//    @Qualifier("sub")
//    private Calculator calcy;

    @Autowired
    @Qualifier("cal1")
    private Calculator cal1;
    @Autowired
    @Qualifier("cal2")
    private Calculator cal2;

    @Override
    public void run(String... args) throws Exception {
//        Calculator calc1 = context.getBean("add", Calculator.class);
//        log.info("get calc={}", calc1.calc(5, 6));
//        Calculator calc2 = context.getBean("sub", Calculator.class);
//        Calculator calc = context.getBean(Calculator.class);
//        log.info("get calc={}", calc.calc(6, 6));
//        log.info("get calc={}", calcx.calc(5, 6));
//        log.info("get calc={}", calxy.calc(6, 6));

        log.info("get calc={}", cal1.calc(5, 6));
        log.info("get calc={}", cal2.calc(6, 6));
    }
}
