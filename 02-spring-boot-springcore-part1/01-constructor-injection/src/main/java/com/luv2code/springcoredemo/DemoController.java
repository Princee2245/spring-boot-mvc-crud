package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach MyCoach;

    @Autowired
    public DemoController(Coach theCoach){
        MyCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return MyCoach.getDailyWorkout();
    }
}
