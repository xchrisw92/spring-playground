package com.example.demo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@SpringBootTest
//@AutoConfigureMockMvc   these two annotations are used to test the full application
@WebMvcTest(WordCounterController.class)
public class WordCounterTest {

    @MockBean
    WordCounter config;

    @Autowired
    MockMvc mvc;

    //Using @BeforeEach and MockBean are used to test only the controller.
    //To show that the controller is receiving requests the right way.
    @BeforeEach
    public void setup(){
        Map<String, Integer> result = new HashMap<>();
        result.put("How", 1);
        result.put("now", 1);
        result.put("cow", 2);

        when(config.count("How now brown cow cow")).thenReturn(result);
    }


    @Test
    void wordCountReturnsJsonOfString() throws Exception {
        MockHttpServletRequestBuilder request = post("/words/count")
                .contentType(MediaType.TEXT_PLAIN)
                .content("How now brown cow cow");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.How", is(1)))
                .andExpect(jsonPath("$.cow", is(2)));

    }



    @Test
    void wordCountEndPointTest() {
        WordCounter test = new WordCounter();

    }
}
