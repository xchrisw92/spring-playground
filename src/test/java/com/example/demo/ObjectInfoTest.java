package com.example.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(ObjectInfo.class)

public class ObjectInfoTest {

    @Autowired
    MockMvc mvc;

    @Test
    void testSpringAutomaticallyMapsParameters() throws Exception {
        this.mvc.perform(get("/Info?sort-by=ascending&name=Chris"))
                .andExpect(status().isOk());

    }
}
