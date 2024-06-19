package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(
//		// if every thing is one package no need of it but coach and cricketCoach is in different package
//		scanBasePackages = {"com.luv2code.springcoredemo",
//							"com.luv2code.util"	}
//)

@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
