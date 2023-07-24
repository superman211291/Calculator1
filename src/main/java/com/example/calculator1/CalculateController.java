package com.example.calculator1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculateController {

    private final Calculator calculator;

    public CalculateController(Calculator calculator) {
        this.calculator = calculator;
    }
    @GetMapping("/plus")
    public String plus(@RequestParam String num1, @RequestParam String num2){
        try {
            return calculator.sum(num1,num2);
        } catch (IllegalArgumentException e){
            return "illegal argument!";
        }
    }
    @GetMapping("/minus")
    public String minus(@RequestParam String num1, @RequestParam String num2){
        try{
        return calculator.minus(num1,num2);
        } catch (IllegalArgumentException e){
            return "illegal argument!";
        }
    }
    @GetMapping("/multiply")
    public String multiply(@RequestParam String num1, @RequestParam String num2){
        try{
        return calculator.multiply(num1,num2);
        } catch (IllegalArgumentException e){
            return "illegal argument!";
        }
    }
    @GetMapping("/divide")
    public String divide(@RequestParam String num1, @RequestParam String num2){
       try{
           return calculator.divide(num1,num2);
       } catch (IllegalArgumentException e){
           return "illegal argument!";
       }
    }
}
