package com.example.demo;



import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


public class WordCounter {
    private  Map<String, Integer> wordCountMap = new HashMap<>();
    private String inputData;

    public  Map<String, Integer> count(String input) {
        this.inputData = input.toLowerCase();
        String[] inputArray = inputData.split(" ");
        for (String s: inputArray) {
            Integer wordOccurrence = wordCountMap.get(s);
            if (wordOccurrence == null) {
                wordCountMap.put(s, 1);
            } else {
                wordCountMap.put(s, wordOccurrence + 1);
            }
        }
        return wordCountMap;
    }

}
