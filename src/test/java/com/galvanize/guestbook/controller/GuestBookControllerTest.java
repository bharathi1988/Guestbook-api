package com.galvanize.guestbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.guestbook.model.GuestBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class GuestBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
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



}
