package com.galvanize.guestbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.model.GuestBook;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GuestBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @Order(1)
    public void addCommentsTest() throws Exception{
        GuestBook guestBookEntry = new GuestBook("Bharathi","Good Guest Book");

        mockMvc.perform(post("/guestbooks/comments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(guestBookEntry)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.guestName").value("Bharathi"))
                .andExpect(jsonPath("$.comments").value("Good Guest Book"));
    }

    @Test
    @Order(2)
    public void getGuestBookEntryTest() throws Exception{
        mockMvc.perform(get("/guestbooks/comments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.[0].guestName").value("Bharathi"))
                .andExpect(jsonPath("$.[0].comments").value("Good Guest Book"));
    }

}
