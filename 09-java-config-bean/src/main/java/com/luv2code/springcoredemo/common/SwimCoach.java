package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;


public class SwimCoach implements  Coach{

    public SwimCoach(){
        System.out.println("Swim class created");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters";
    }
}
