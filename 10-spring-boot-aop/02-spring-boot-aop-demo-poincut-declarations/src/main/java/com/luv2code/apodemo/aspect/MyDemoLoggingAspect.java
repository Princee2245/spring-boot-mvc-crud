package com.luv2code.apodemo.aspect;

import com.luv2code.apodemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

//    @Pointcut("execution(* com.luv2code.apodemo.DAO.*.*(..))")
//    private void forDaoPackage(){};
//
//    @Before("forDaoPackage()")
//    public void beforeAddAccountAdvice(){
//        System.out.println("\n====>>> Executing @Before advice on addAccount()");
//    }
//
//    @Before("forDaoPackage()")
//    public void performApiAnalytics(){
//        System.out.println("\n====>>> doing some fancy work");
//    }




    @Before("com.luv2code.apodemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
        System.out.println("\n====>>> Executing @Before advice on addAccount()");

    //display method signature
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);

        //display method arguments

        Object[] args=theJoinPoint.getArgs();

        for(Object tempArg:args){
            System.out.println(tempArg);

            if(tempArg instanceof Account){
                //downcast and print account stuff
                Account account=(Account) tempArg;
                System.out.println("Account name: "+account.getName());
                System.out.println("Account level: "+account.getLevel());
            }
        }


    }




    //order wise 1 has higher priority if both have same order then order is undefined

// add new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.luv2code.apodemo.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        //print out which method we are advising
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterReturning on method: "+method);



        //print out the result of the method call
        System.out.println("\n====>>>> result is: "+result);

        //let's post-process the data

        //covert the account name to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n====>>>> result is: "+result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for(Account account:result){
            account.setName(account.getName().toUpperCase());
        }

    }


    @AfterThrowing(
            pointcut = "execution(* com.luv2code.apodemo.DAO.AccountDAO.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowing(
            JoinPoint theJointPoint,Throwable theExc){

        //print out which method we are advising
        String method=theJointPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @AfterThrowing on method: "+method);

        //log exception
        System.out.println("\n====>>>> the Exception is: "+theExc);

    }


    @After( "execution(* com.luv2code.apodemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint theJointPoint){

        //print out which method we are advising
        String method=theJointPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @After finally on method: "+method);

    }

    @Around( "execution(* com.luv2code.apodemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        //print out method we are advising on
        String method=theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n====>>>> Executing @Around on method: "+method);

        //get begin timestamp
        long begin=System.currentTimeMillis();

        //now,let's execute the method

        Object result=null;

        try {
            result=theProceedingJoinPoint.proceed();
        }catch (Exception exc){
            System.out.println(exc.getMessage());

            throw exc;

        }

        //get end timestamp

        long end=System.currentTimeMillis();

        //compute duration and display it

        long duration=end-begin;

        System.out.println("\n===>>> Duration: "+duration/1000.0+" seconds");

        return result;
    }
}
