package com.fet.springboot_demo1;

import com.fet.springboot_demo1.controllers.RootController;
import com.fet.springboot_demo1.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers= RootController.class)
public class SpringTest3 {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void isNotNull() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(content().string(containsString("Fet")));
    }

    @MockBean
    private GreetingService service;

    @Test
    public void serviceAndController() throws Exception {
        when(service.greet()).thenReturn("Hi, FET is best!");
        mockMvc.perform(get("/greeting")).andDo(print())
                .andExpect(content().string(containsString("FET")));
    }
}
