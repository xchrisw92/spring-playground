package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class QuestionsController {

    @GetMapping("/all")
    public String getQuestion(){
        return "Nailed it!";
    }
    @GetMapping("/ageInput")
    public String inputAge(@RequestParam(defaultValue = "10") String age){
        return String.format("You are %s years old" , age);
    }

    @GetMapping("/birthday")
    public String birthdayMonth(@RequestParam Map birthday){
        return birthday.toString();
    }

    @GetMapping("/Info")
    public String getTasks(ObjectInfo objectInfo){

        return String.format("sort-by is %s; owner is %s", objectInfo.getSortBy(), objectInfo.getOwner());
    }

    @GetMapping("/drivers/{driverId}/name/{DriverName}")
    public String getIndividualParams(DriversInfo info){
        return String.format("Driver ID: %s Driver name: %s", info.getDriverId(), info.getDriverName());
    }

}
