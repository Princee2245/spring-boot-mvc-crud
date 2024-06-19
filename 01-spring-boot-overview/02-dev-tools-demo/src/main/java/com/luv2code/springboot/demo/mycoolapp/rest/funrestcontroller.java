package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class funrestcontroller {

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
