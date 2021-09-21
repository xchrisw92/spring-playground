package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequestMapping("/json")
public class JsonPracticeController {

    @GetMapping("/simple-object")
    public Person getName(){
        Person chrisPerson = new Person();
        chrisPerson.setFirstname("Chris");
        chrisPerson.setLastname("Welton");

        return chrisPerson;
    }

    @GetMapping("/simple-array")
    public List<Person> getNameList(){
        List<Person> resultList = new ArrayList<>();
        Person chrisPerson = new Person();
        chrisPerson.setFirstname("Chris");
        chrisPerson.setLastname("Welton");
        resultList.add(chrisPerson);

        return resultList;
    }


    @GetMapping("/flight")
    public Flight getFlightList(){
        Flight flight1 = new Flight();

        Date tomorrow =  new Date();

        Flight.Person chris = new Flight.Person();
        chris.setFirstname("Chris");
        Flight.Person mike = new Flight.Person();
        mike.setFirstname("Mike");
        Flight.Person welton = new Flight.Person();
        welton.setFirstname("Welton");

        flight1.setPassengers(Arrays.asList(mike, welton));

        flight1.setId("AF1223");

        flight1.setLandsAt("AUS");

        flight1.setSecretInfo("Hello");

        flight1.setDepartsOn(tomorrow);

        flight1.setPilot(chris);

        flight1.setPrice(200.00);

        return flight1;
    }

    @GetMapping("/object-example")
    public Map<String, String> getJsonData(@RequestBody Map<String , String> jsonInput){


        return jsonInput;
    }
    @GetMapping("/object-mapper")
    public Person getJsonFromMapper(@RequestBody Person person){
        return person;
    }




}
