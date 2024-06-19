package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrestcontroller {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;
    //expose new endpoint for teaminfo

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "coach: "+ coachName+" , teamName: "+ teamName;
    }


    @GetMapping("/")
    public String sayHello(){
        return "Hello world";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run Daily";
    }

    @GetMapping("/fortune")
    public String getDialyFourtune(){
        return "today is fortune";
    }
}
