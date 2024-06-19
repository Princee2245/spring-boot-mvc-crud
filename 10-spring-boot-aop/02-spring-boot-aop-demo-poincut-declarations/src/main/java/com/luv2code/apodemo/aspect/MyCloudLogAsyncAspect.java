package com.luv2code.apodemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyCloudLogAsyncAspect {


    @Before("com.luv2code.apodemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
    public void logToCloudAsync(){
        System.out.println("\n====>>> logging to cloud in async fashion");
    }
}
