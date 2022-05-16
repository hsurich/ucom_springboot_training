package com.springboot.demo.demo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class Runner1 implements CommandLineRunner {
    @Autowired
    private BeverageRepository repository;

    @Override
    public void run(String... args) throws Exception {
        // insert
        fillBeverage();
        // select
        dumpAllBeverage();
        // modify
        modifyGreenTea();
        dumpAllBeverage();
        // delete
        deleteRecord();
        dumpAllBeverage();
    }


    private void deleteRecord() {
        Optional<Beverage> optBeverage = repository.findById(8L);
        Beverage b = optBeverage.get();
        repository.delete(b);
        log.info("----*****------***********-----------");
    }

    private void modifyGreenTea() {
        Optional<Beverage> optBeverage = repository.findById(6L);
        Beverage b = optBeverage.get();
        b.setTitle("Kyoto Hot Green Tea");
        repository.save(b);
        log.info("------------------------");
    }

    private void dumpAllBeverage() {
        for (Beverage b: repository.findAll()) {
            log.info("get a beverage:{}", b);
        }

    }

    private void fillBeverage() {
        repository.save(new Beverage("Hot Coffee", "With Milk"));
        repository.save(new Beverage("Hot Coffee", "No Milk"));
        repository.save(new Beverage("Ice Coffee", "With Milk"));
        repository.save(new Beverage("Ice Coffee", "No Milk"));
        repository.save(new Beverage("Hot Green Tea", "With Milk"));
        repository.save(new Beverage("Hot Green Tea", "No Milk"));
        repository.save(new Beverage("Hot Red Tea", "With Milk"));
        repository.save(new Beverage("Hot Red Tea", "No Milk"));

    }
}

