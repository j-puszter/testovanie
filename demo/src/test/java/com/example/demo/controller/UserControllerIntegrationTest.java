package com.example.demo.controller;

import com.example.demo.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserController controller;

    @Test
    public void listUsers() throws Exception {
        mvc.perform(get("/user/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())                                 // Result je pole
                .andExpect(jsonPath("$[5]").doesNotExist())                         // V poli je len 5 položiek
                .andExpect(jsonPath("$[0].username").value("a"));       // Prvý používateľ má username 'a'
    };

    @Test
    public void createUser() throws Exception {
        User newUser = new User(5, "f", "f");       // Vytvorenie nového používateľa
        ObjectMapper mapper = new ObjectMapper();
        mvc.perform(post("/user/create")
                        .contentType(MediaType.APPLICATION_JSON)         // Nastavenie typu odosielaných dát
                        .content(mapper.writeValueAsString(newUser)))    // Vloženie dát do requestu
                .andDo(print())
                .andExpect(status().isOk())                              // Očakávaný status
                .andExpect(header().string("Age", "1"))      // Očakávaná hlavička
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))     // Očakávaný typ dát
                .andExpect(jsonPath("$.username").value("f"));
    };


    // Unit test

    @Test
    public void listUsers2() throws Exception {
        Assertions.assertEquals(controller.list().getBody().size(), 5);
    };

}