package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(MathController.class)
public class MathControllerTest {

@Autowired
private MockMvc mvc;


    @Test
    void testMathIndexEndpoint() throws Exception {

        this.mvc.perform(get("/math/pi"))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(Math.PI)));
    }

    @Test
    void mathCalculateEndpointAdditionWorks() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 6 = 10"));
    }

    @Test
    void mathCalculateEndpointOperationsAddSubtractMultiplyDivideWork() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=subtract&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 - 6 = -2"));

        this.mvc.perform(get("/math/calculate?operation=multiply&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 * 6 = 24"));

        this.mvc.perform(get("/math/calculate?operation=divide&x=4&y=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 / 6 = 0"));
    }

    @Test
    void mathSumWillAddAnUnknownAmountOfValues() throws Exception {
        this.mvc.perform(post("/math/sum?n=4&n=5&n=6"))
                .andExpect(status().isOk())
                .andExpect(content().string("4 + 5 + 6 = 15"));

    }
}
