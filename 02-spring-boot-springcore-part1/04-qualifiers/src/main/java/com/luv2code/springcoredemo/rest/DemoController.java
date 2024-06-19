package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach MyCoach;

    //keep the first letter of class name to be lowercase
    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach theCoach){
        MyCoach=theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return MyCoach.getDailyWorkout();
    }
}
