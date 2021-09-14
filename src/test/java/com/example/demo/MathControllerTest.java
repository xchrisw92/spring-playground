package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

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

    @Test
    void mathVolumeReturnsVolumeOfARectangleUsingGet() throws Exception {
        this.mvc.perform(get("/math/volume/3/4/5"))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 3x4x5 rectangle is 60"));

    }

    @Test
    void mathAreaReturnsAreaOfACircleOrRectangle() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "circle")
                .param("radius", "2");
        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a circle with a radius of 2 is 12.566370614359172."));
        request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "rectangle")
                .param("width", "2")
                .param("height", "4");
        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Area of a 2x4 rectangle is 8.0"));

    }

    @Test
    void mathAreaReturnsInvalidGivenBadParams() throws Exception {
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("type", "triangle")
                .param("hypotenuse", "1.4");
        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

    }
}
