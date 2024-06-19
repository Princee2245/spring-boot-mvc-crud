package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);

		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id=1;
		appDAO.deleteInstructorId(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor");

		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
//
//		Instructor tempInstructor=new Instructor("prince","Pansuriya","prince@gmail.com");
//
//		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.prince/youtube","love 2 code");



		Instructor tempInstructor=new Instructor("ritik","Pansuriya","ritik@gmail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.ritik/youtube","love 2 code");


		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//this will also save the details object
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}
}
