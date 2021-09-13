package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
 class HelloController {

    @GetMapping("/")
    public String homePage(){
        return "GET to index route";
    }

    @PostMapping("/messages")
    public String postMessage(){
        return "POST to messages route";
    }

}
