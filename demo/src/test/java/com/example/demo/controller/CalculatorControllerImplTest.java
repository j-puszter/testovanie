package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
class CalculatorControllerImplTest {

    @MockBean
    CalculatorController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void primeNumbers() throws Exception {
        MvcResult result = this.mockMvc
                .perform(get("/primes/{n}", 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(content().json());
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void isPrime() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc
                .perform(post("/isPrime")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString("1"))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("true"));
    }
}