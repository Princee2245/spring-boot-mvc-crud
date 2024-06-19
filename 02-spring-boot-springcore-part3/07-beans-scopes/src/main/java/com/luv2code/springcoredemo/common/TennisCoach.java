package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements  Coach{

    public TennisCoach(){
        System.out.println("Tennis Coach created");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice backend";
    }
}
