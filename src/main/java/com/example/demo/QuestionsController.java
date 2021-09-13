package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionsController {

    @GetMapping("/all")
    public String getQuestion(){


        return "Nailed it!";
    }
    @GetMapping("/math/pi")
    public String piValue(){
        return "3.141592652589793";
    }

}
