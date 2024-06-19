package com.luv2code.apodemo;

import com.luv2code.apodemo.DAO.AccountDAO;
import com.luv2code.apodemo.DAO.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApodemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MemberShipDAO memberShipDAO){
		return runner->{
			demoTheBeforeAdvice(theAccountDAO,memberShipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MemberShipDAO memberShipDAO) {
		Account account=new Account();

		theAccountDAO.addAccount(account,false);
		theAccountDAO.doWork();
		memberShipDAO.addSilly();
		memberShipDAO.goToSleep();

	}
}
