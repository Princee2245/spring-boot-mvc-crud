package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
//			deleteInstructor(appDAO);

//			createInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);

//			findInstructorWithCourses(appDAO);

//			findCoursesForInstructor(appDAO);

//			findInstructorWithCoursesJoinFetch(appDAO);

//			updateInstructor(appDAO);

//			updateCourse(appDAO);

//			deleteInstructor(appDAO);

			deleteCourseById(appDAO);

		};
	}

	private void deleteCourseById(AppDAO appDAO) {
		int id=10;

		appDAO.deleteCourseById(id);
	}

	private void updateCourse(AppDAO appDAO) {
	int id=10;

	Course tempCourse=appDAO.findCourseById(id);

	tempCourse.setTitle("AIR");
	appDAO.update(tempCourse);
		System.out.println("done");

	}

	private void updateInstructor(AppDAO appDAO) {
		int id=1;

		Instructor temp=appDAO.findInstructorById(id);

		System.out.println("updating: ");
		temp.setLastName("Pan");
		appDAO.update(temp);
		System.out.println("done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

	int id=1;

	Instructor temp=appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("instructor: "+temp);
		System.out.println("the courses: "+temp.getCourses());

		System.out.println("done");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		Instructor tempInstructor=appDAO.findInstructorById(id);

		//this is called lazy initialization as we get courses of the
		List<Course> courses=appDAO.findCourseByInstructorId(id);

		tempInstructor.setCourses(courses);
		System.out.println("the courses are: "+tempInstructor.getCourses());
	}



	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=1;
		Instructor tempInstructor=appDAO.findInstructorById(id);
		System.out.println("tempInstructor: "+tempInstructor);

		System.out.println("Courses"+tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor=new Instructor("prince","Pansuriya","prince@gmail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.prince/youtube","love 2 code");



		Instructor tempInstructor2=new Instructor("ritik","Pansuriya","ritik@gmail.com");

		InstructorDetail tempInstructorDetail2=new InstructorDetail("http://www.ritik/youtube","love 2 code");


		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);

		Course tempCourse1=new Course("Air guitar");
		Course tempCourse2=new Course("Ping Ball");
		Course tempCourse3=new Course("Cricket");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor2.add(tempCourse3);

		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor2);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
	int id=4;
	appDAO.deleteInstructorDetailById(id);

	}

	private void createInstructorDetail(AppDAO appDAO) {
		int id=3;
		InstructorDetail instructorDetail=appDAO.findInstructorDetailById(id);
		System.out.println("instructorDetail: "+instructorDetail);

		System.out.println("instructor: "+instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id=1;
//		appDAO.deleteInstructorId(id);
		appDAO.deleteInstructorById(id);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor");

		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor=new Instructor("prince","Pansuriya","prince@gmail.com");

		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.prince/youtube","love 2 code");



		Instructor tempInstructor2=new Instructor("ritik","Pansuriya","ritik@gmail.com");

		InstructorDetail tempInstructorDetail2=new InstructorDetail("http://www.ritik/youtube","love 2 code");


		//associate the object
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor2.setInstructorDetail(tempInstructorDetail2);
		//this will also save the details object
		appDAO.save(tempInstructor);
		appDAO.save(tempInstructor2);
		System.out.println("Done");
	}
}
