package com.luv2code.apodemo;

import com.luv2code.apodemo.DAO.AccountDAO;
import com.luv2code.apodemo.DAO.MemberShipDAO;
import com.luv2code.apodemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ApodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApodemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberShipDAO memberShipDAO, TrafficFortuneService theTrafficFortuneService){
		return runner->{
//			demoTheBeforeAdvice(theAccountDAO,memberShipDAO);

//			demoAfterReturningAdvice(theAccountDAO);

//			demoAfterThrowingAdvice(theAccountDAO);
			
//			demoTheAfterAdvice(theAccountDAO);

//			demoTheAroundAdvice(theTrafficFortuneService);

//			demoTheAroundAdviceHandleException(theTrafficFortuneService);

			demoTheAroundAdviceRethrowException(theTrafficFortuneService);

		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain program: demoTheAroundAdviceRethrowException");
		System.out.println("calling getFortune()");

		boolean tripwire=true;
		String data=theTrafficFortuneService.getFortune(tripwire);

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");


	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain program: demoTheAroundAdviceHandleException");
		System.out.println("calling getFortune()");

		boolean tripwire=true;
		String data=theTrafficFortuneService.getFortune(tripwire);

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");

	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain program: demoTheAroundAdvice");
		System.out.println("calling getFortune()");

		String data=theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: "+data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {

		List<Account> accountList=null;

		try{
			// add a boolean flag to stimulate the exception
			boolean tripWire=true;
			accountList=theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\nMain Program: caught exception: "+exc);
		}

		System.out.println("\n\nMain Program: demoAfterThrowingAdvice");
		System.out.println("---");

		System.out.println(accountList);
		System.out.println("\n");

	}

	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {

		List<Account> accountList=null;

		try{
			// add a boolean flag to stimulate the exception
			boolean tripWire=false;
			accountList=theAccountDAO.findAccounts(tripWire);
		}catch (Exception exc){
			System.out.println("\nMain Program: caught exception: "+exc);
		}

		System.out.println("\n\nMain Program: demoAfterThrowingAdvice");
		System.out.println("---");

		System.out.println(accountList);
		System.out.println("\n");

	}

	private void demoAfterReturningAdvice(AccountDAO theAccountDAO) {

		//call method to find accounts

		List<Account> accountList=theAccountDAO.findAccounts();

		System.out.println("\n\nMain Program: demoAfterReturningAdvice");
		System.out.println("---");

		System.out.println(accountList);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MemberShipDAO memberShipDAO) {
		Account account=new Account();
		account.setName("Prince");
		account.setLevel("platinum");

		theAccountDAO.addAccount(account,false);
		theAccountDAO.doWork();

		// call the accountdao getter/setter methods

		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		String name=theAccountDAO.getName();
		String serviceCode=theAccountDAO.getServiceCode();

		memberShipDAO.addSilly();
		memberShipDAO.goToSleep();

	}
}
