package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 class HelloController {

    @GetMapping("/")
        public String getGreeting(){
        return "Hello Spring!";
    }
}
