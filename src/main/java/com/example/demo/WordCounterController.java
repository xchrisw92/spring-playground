package com.example.demo;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class WordCounterController {

    private final WordCounter wordCounter;
    public WordCounterController(WordCounter counter){
        this.wordCounter = counter;
    }

    @PostMapping("/words/count")
    public Map<String, Integer> getWordCount(@RequestBody String input){
       return wordCounter.count(input);
    }
}
