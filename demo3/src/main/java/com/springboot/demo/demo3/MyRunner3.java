package com.springboot.demo.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    private static final String DROP_DDL = "DROP TABLE users IF EXISTS";
    private static final String CREATE_DDL = "CREATE TABLE users(id SERIAL, username VARCHAR(255),email VARCHAR(255))";
    private static final String INSERT_DML = "INSERT INTO users(username, email) VALUES(?,?)";
    private static final String SELECT_DML = "SELECT * FROM users";
    private static final String SELECTION_SELECT_DML = "SELECT id, username, email FROM users WHERE username = ?";

    @Override
    public void run(String... args) throws Exception {
        template.execute(DROP_DDL);
        template.execute(CREATE_DDL);

        // List<Object[]> users = Arrays.asList(USERS_STRING).stream().map(new Function<String, String[]>() {
        List<Object[]> users = Arrays.stream(USERS_STRING).map(new Function<String, String[]>() {
            @Override
            public String[] apply(String s) {
                return s.split(" ");
            }
        }).collect(Collectors.toList());
        log.info("users = {}", users);

        template.batchUpdate(INSERT_DML, users);

        log.info("read it back");
        template.query(SELECT_DML, (rs, number) -> {
            log.info("number={}", number);
            return new User(rs.getString("username"), rs.getString("email"));
        }).forEach(u -> log.info(u.toString()));

        log.info("---selection select---");
        /*
        template.query(SELECTION_SELECT_DML, new Object[]{"John"},
                        (rs, rowNum) -> new User(rs.getString("username"), rs.getString("email")))
                .forEach(u -> log.info("query John only-->{}", u.toString()));

         */
        RowMapper<User> userRowMapper = (rs, rowNum) -> new User(rs.getString("username"), rs.getString("email"));
        template.query(SELECTION_SELECT_DML, userRowMapper, "John").
                forEach(u -> log.info("query John only-->{}", u.toString()));
    }
}