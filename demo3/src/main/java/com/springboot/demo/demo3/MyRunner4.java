package com.springboot.demo.demo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyRunner4 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate template;
    private static final String SELECT_SQL = "SELECT id, username, email from users2 where id = :id";

    @Override
    public void run(String... args) throws Exception {
        SqlParameterSource source = new MapSqlParameterSource().addValue("id", 1);
        User user = template.queryForObject(SELECT_SQL, source,
                (rs, rowNum) -> new User(rs.getString("username"), rs.getString("email")));
        log.info("user={}", user);
    }
}

