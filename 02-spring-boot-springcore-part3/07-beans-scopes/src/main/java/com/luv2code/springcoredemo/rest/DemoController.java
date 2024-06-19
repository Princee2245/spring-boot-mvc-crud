package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach MyCoach;
    private Coach AnotherCoach;

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach Another){

        System.out.println("in constructor: "+getClass().getSimpleName());
        MyCoach=theCoach;
        AnotherCoach=Another;
    }

    @GetMapping("/check")
    public String check(){
        return "Compare Beans: myCoach==AnotherCoach "+ (MyCoach==AnotherCoach);
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return MyCoach.getDailyWorkout();
    }
}
