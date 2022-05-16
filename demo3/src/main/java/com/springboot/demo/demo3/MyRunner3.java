package com.springboot.demo.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class MyRunner3 implements CommandLineRunner {
    @Autowired
    JdbcTemplate template;
    private static final String[] USERS_STRING = {"mark mark@abc.com", "John hohn@def.com", "Tim tim@prq.com"};

    @Override
    public void run(String... args) throws Exception {
        List<Object[]> users = Arrays.asList(USERS_STRING).stream().map(new Function<String, String[]>() {
            @Override
            public String[] apply(String s) {
                return s.split(" ");
            }
        }).collect(Collectors.toList());
        log.info("users = {}", users);
    }
}