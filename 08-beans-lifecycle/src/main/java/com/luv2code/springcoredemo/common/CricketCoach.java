package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach{

    public CricketCoach(){
        System.out.println("Cricket Coach Created");
    }

    //define init method
    @PostConstruct
    public void doMyStartingStuff(){
        System.out.println("In domystartupstuff(): "+getClass().getSimpleName());

    }
    //define our destroy method
    @PreDestroy
    public void doMyCleanStuff(){
        System.out.println("In domyCleanupstuff(): "+getClass().getSimpleName());

    }

    @Override
    public String getDailyWorkout() {
        return "Cricket coach !!";
    }
}
