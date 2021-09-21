package com.example.demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JsonPracticeController.class)

public class JsonPracticeTest {
    @Autowired
    MockMvc mvc;

    @Test
    void jsonPracticeNewSyntaxForObject() throws Exception {
        MockHttpServletRequestBuilder result = get("/json/simple-object")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        this.mvc.perform(result)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname" , is("Chris")))
                .andExpect(jsonPath("$.lastname", is("Welton")));

    }

    @Test
    void jsonPracticeTestNewSyntaxForArray() throws Exception {

        MockHttpServletRequestBuilder result = get("/json/simple-array")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(result)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstname", is("Chris")))
                .andExpect(jsonPath("$[0].lastname" , is("Welton")));
    }


    //Test Json data using Object Mapper function
    @Test
    void testObjectParams() throws Exception{
        MockHttpServletRequestBuilder request = get("/json/object-example")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"firstName\": \"Chris\", \"lastName\" : \"Welton\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", is("Chris")))
                .andExpect(jsonPath("$.lastname", is("Welton")));
    }

    @Test
    void testObjectMapper() throws Exception {

        ObjectMapper test = new ObjectMapper();
        Person testPerson = new Person();
        testPerson.setLastname("Welton");
        testPerson.setFirstname("Chris");


        String json = test.writeValueAsString(testPerson);

        MockHttpServletRequestBuilder result = get("/json/object-mapper")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(result)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstname", is("Chris")))
                .andExpect(jsonPath("$.lastname", is("Welton")));

    }
}
