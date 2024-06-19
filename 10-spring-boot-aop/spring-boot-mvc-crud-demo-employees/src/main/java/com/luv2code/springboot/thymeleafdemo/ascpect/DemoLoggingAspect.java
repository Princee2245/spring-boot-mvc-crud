package com.luv2code.springboot.thymeleafdemo.ascpect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //setup logger

    private Logger myLogger=Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forController(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forService(){}

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forController() || forService() || forDaoPackage()")
    private void forAppFlow(){};

    @Before("forAppFlow()")
    public void before(JoinPoint theJointPoint){
        //display the method we are calling
        String theMethod=theJointPoint.getSignature().toShortString();
        myLogger.info("====>>> in @Before: calling method: "+theMethod);

        //display the arguments to the method
        Object[] args=theJointPoint.getArgs();

        for(Object tempargs:args){
            myLogger.info("===>>> argument: "+tempargs);
        }

    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "theResult")
    public void afterReturning(JoinPoint joinPoint,Object theResult){

        String theMethod=joinPoint.getSignature().toShortString();
        myLogger.info("====>>> in @AfterReturning: calling method: "+theMethod);

        myLogger.info("====>>> result: "+theResult);

    }
}
