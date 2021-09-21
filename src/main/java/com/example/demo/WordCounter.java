package com.example.demo;



import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordCounter {
    private  Map<String, Integer> wordCountMap = new HashMap<>();


    public  Map<String, Integer> count(String input) {
        Map<String, Integer> resultMap = new HashMap<>();
        String[] inputArray = input.split(" ");
        for (String s: inputArray) {
            Integer wordOccurrence = resultMap.get(s);
            if (wordOccurrence == null) {
                resultMap.put(s, 1);
            } else {
                resultMap.put(s, wordOccurrence + 1);
            }
        }
        return resultMap;
    }

}
