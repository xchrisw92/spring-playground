package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(QuestionsController.class)

public class QuestionsControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void testQueryStringForNameAndAge() throws Exception {
        this.mvc.perform(get("/ageInput?age=29"))
                .andExpect(status().isOk());

    }

    @Test
    void QueryStringCreatesBirthdateMap() throws Exception {
        this.mvc.perform(get("/birthday?month=June"))
                .andExpect(status().isOk());

    }

    @Test
    void testIndexEndPointForDrivers() throws Exception {

        this.mvc.perform(get(String.format("/drivers/345/name/Chris")))
                .andExpect(status().isOk());
    }
}
