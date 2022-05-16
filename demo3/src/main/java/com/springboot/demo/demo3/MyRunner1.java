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
public class MyRunner1 implements CommandLineRunner {
    @Autowired
    NamedParameterJdbcTemplate template;
    private static final String SQL1 = "SELECT 888";

    @Override
    public void run(String... args) throws Exception {
        log.info("jdbc template:{}", template.getJdbcTemplate().getDataSource());
        SqlParameterSource source = new MapSqlParameterSource();
        Integer result = template.queryForObject(SQL1, source, Integer.class);
        log.info("query from {}, result is {}", SQL1, result);
    }
}

