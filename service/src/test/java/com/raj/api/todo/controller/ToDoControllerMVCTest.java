package com.raj.api.todo.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ToDoControllerMVCTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @Order(1)
    public void createToDo() throws Exception {
        var jsonString = "{ \"name\" : \"Buy milk\", \"completed\" : false }";

        this.mockMvc.perform(post("/todos").content(jsonString).contentType("application/json")).andExpect(status().isCreated())
                .andExpect(content().string(containsString("Buy milk")))
                .andExpect(content().string(containsString("1")));
    }

    @Test
    @Order(2)
    public void getToDo() throws Exception {
        this.mockMvc.perform(get("/todos/1")).andExpect(status().isOk())
                .andExpect(content().string(containsString("completed")));
    }
}