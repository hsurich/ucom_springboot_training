package com.fet.springboot_demo1;

import com.fet.springboot_demo1.controllers.RootController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SpringTest1 {
    @Autowired
    private RootController controller;

    @Test
    void isNotNull() {
        assertThat(controller).isNotNull();
    }
}
