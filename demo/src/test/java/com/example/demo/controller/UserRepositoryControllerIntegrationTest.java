package com.example.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
class UserRepositoryControllerIntegrationTest {

    @MockBean
    CalculatorController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("GET /primes/{n}")
    void primeNumbers() throws Exception {

        this.mockMvc
                .perform(get("/primes/{n}", 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                //.andExpect(content().)
                .andExpect(content().json("[2,3,5]"));
    }

    @Test
    @DisplayName("POST 200 /isPrime")
    void isPrime() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc
                .perform(post("/isPrime")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString("1"))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Age", "value"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("POST 400 /isPrime")
    void isPrimeBadRequest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc
                .perform(post("/isPrime")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString("a"))
                )
                .andDo(print())
                .andExpect(status().is(400));
    }

    @Test
    @DisplayName("GET 404")
    void notFound() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc
                .perform(get("/404"))
                .andDo(print())
                .andExpect(status().is(404));
    }
/*
    @Test
    @DisplayName("GET 500  /isPrime/{n}")
    void serverError() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        this.mockMvc
                .perform(get("/isPrime/{n}", 0))
                .andDo(print())
                .andExpect(status().is(500));
    }

 */
}