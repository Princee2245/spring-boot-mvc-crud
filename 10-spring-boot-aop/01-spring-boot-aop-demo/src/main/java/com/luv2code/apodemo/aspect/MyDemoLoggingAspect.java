package com.luv2code.apodemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void com.luv2code.apodemo.DAO.MemberShipDAO.addAccount())")
//    @Before("execution(public void add*())")
//    @Before("execution(* add*())")//any return type
//
//    @Before("execution(* add*(com.luv2code.apodemo.Account,..))") //parameter account followed by any number of argument

    @Before("execution(* com.luv2code.apodemo.DAO.*.*(..))") //return type package .*.*=class,method and (..)=any number of parameter
    public void beforeAddAccountAdvice(){
        System.out.println("\n====>>> Executing @Before advice on addAccount()");
    }
}
