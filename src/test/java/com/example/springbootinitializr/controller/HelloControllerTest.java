package com.example.springbootinitializr.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HelloController.class)
@AutoConfigureMockMvc
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void it_should_return_hello_world_when_name_is_empty() throws Exception {
        this.mockMvc.perform(get("/hello")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void it_should_return_hello_name_when_name_is_not_empty() throws Exception {
        String name = "Fatiha";

        this.mockMvc.perform(get("/hello?name=" + name)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + name)));
    }

    @Test
    public void it_should_return_result_in_upper_case_when_name_is_upper_case() throws Exception {
        String name = "TEYYIHAN";

        this.mockMvc.perform(get("/hello/" + name)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("HELLO, " + name)));
    }

    @Test
    public void it_should_return_result_in_lower_case_when_name_is_lower_case() throws Exception {
        String name = "teyyihan";

        this.mockMvc.perform(get("/hello/" + name)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, " + name)));
    }

}