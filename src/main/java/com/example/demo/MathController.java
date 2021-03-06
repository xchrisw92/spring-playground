package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/math")

public class MathController {
    private String operation;

    @GetMapping("/pi")
    String getPi(){ return Double.toString(Math.PI); }

    @GetMapping("/calculate")
    String getCalculation(@RequestParam String operation, @RequestParam int x, @RequestParam int y){
        return String.format("%s %s %s = %s" , x, MathService.getOperand(operation), y,
                MathService.calculateOperation(operation, x, y));
    }

    @PostMapping("/sum")
    String sum(@RequestParam MultiValueMap<String, String> input){
        int y = 0;
        String print = "";
        for(int x = 0 ; x<input.get("n").size() - 1 ; x++){
            print += input.get("n").get(x) + " + ";
            y=x;
        }
        print += input.get("n").get(y+1) + " = " + MathService.sum(input.get("n"));
        return print;
    }

    @RequestMapping("/volume/{x}/{y}/{z}")
    String volume(@PathVariable int x, @PathVariable int y, @PathVariable int z){

        return "The volume of a " + x + "x" + y + "x" + z + " rectangle is " + MathService.calculateVolume(x, y, z)
                + ".";
    }
    @PostMapping("/area")
    String area(@RequestParam Map<String, String> params){
        if(params.get("type").equals("circle")){
           return "Area of a circle with a radius of " + params.get("radius") + " is " +
                   String.valueOf(MathService.areaOfCircle(params.get("radius"))) + ".";
        } else if(params.get("type").equals("rectangle")){
            return "Area of a " + params.get("width") + "x" + params.get("height") + " rectangle is " +
                    String.valueOf(MathService.areaOfRectangle(params.get("width"), params.get("height"))) + ".";
        } else { return "Invalid"; }
    }

}
