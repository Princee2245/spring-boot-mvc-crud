package com.luv2code.apodemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpression {

    @Pointcut("execution(* com.luv2code.apodemo.DAO.*.*(..))")
    public void forDaoPackage(){};

    //create a pointcut for getter
    @Pointcut("execution(* com.luv2code.apodemo.DAO.*.get*(..))")
    public void getter() {};

    //create a pointcut for setter
    @Pointcut("execution(* com.luv2code.apodemo.DAO.*.set*(..))")
    public void setter() {};

    //create a pointcut: include package and exclude getter and setter
    @Pointcut("forDaoPackage() && !( getter() || setter() )")
    public void forDaoPackageNoGetterAndSetter() {};


}
