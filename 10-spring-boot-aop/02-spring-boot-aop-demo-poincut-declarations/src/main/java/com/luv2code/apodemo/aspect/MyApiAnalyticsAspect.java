package com.luv2code.apodemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("com.luv2code.apodemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
    public void performApiAnalytics(){
        System.out.println("\n====>>> doing some fancy work");
    }
}
