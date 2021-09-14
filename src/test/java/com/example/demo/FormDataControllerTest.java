package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FormDataController.class)

public class FormDataControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void testCreateComment() throws Exception {

        String content = String.valueOf(new Random().nextInt());
        MockHttpServletRequestBuilder request1 = post("/string-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content");


        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Dwayne said %s!", content)));

    }

    @Test
    void testIndividualAccessRequest() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/individual-example")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("from", "Welton")
                .param("q", "1");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("query: 1 from: Welton"));

    }

    @Test
    void testCreateCommentWithPathIdAndParams() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/posts/34/comments?notify=me&content=you&author=him")
            .contentType(MediaType.APPLICATION_FORM_URLENCODED);

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("postId:34 notify:me content:you author:him"));

    }
}

