package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class FormDataController {

    @PostMapping("/string-example")
    public String getRawString(@RequestBody Map<String, String> body){
        return String.format("%s said %s", body.get("author"), body.get("content"));
    }
    @PostMapping("/individual-example")
    public String getIndividualParams(@RequestParam String from, @RequestParam("q") String query){
        return String.format("query: %s from: %s", query, from);
    }
    @PostMapping("/posts/{postId}/comments")
    public String createComment(@PathVariable int postId, @RequestParam Map<String, String> params){
        return String.format("postId:%d notify:%s content:%s author:%s", postId, params.get("notify"),
                params.get("content"), params.get("author"));
    }
    @GetMapping("/cookie")
    public String getCookie(@CookieValue(name = "hello") String cookie){
        return cookie;
    }
    @GetMapping("/header")
    public String getHeader(@RequestHeader String host){
        return host;
    }

}
