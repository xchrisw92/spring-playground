package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WordCountConfig {

    @Bean
    public WordCounter createWordCounter(){
        return new WordCounter();
    }
}
