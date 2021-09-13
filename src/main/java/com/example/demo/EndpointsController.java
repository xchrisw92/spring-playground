package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class EndpointsController {

    @GetMapping("/task1")
    public String getTasks(){
        return "These are the tasks:";

    }
    @PostMapping("/task2")
    public String createTask(){
        return "You just POSTed to /tasks";
    }


}

