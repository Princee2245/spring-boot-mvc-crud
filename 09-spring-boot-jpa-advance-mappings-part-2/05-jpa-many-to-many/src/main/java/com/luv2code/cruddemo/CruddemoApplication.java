package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.*;
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

//		createCourseAndStudent(appDAO);
		
//		findCourseAndStudent(appDAO);

//		findStudentAndCourse(appDAO);

//		addMoreCourseForStudent(appDAO);

//		deleteCourseById(appDAO);

		deleteStudentById(appDAO);
		};
	}

	private void deleteStudentById(AppDAO appDAO) {
		int id=1;

		appDAO.deleteStudentById(id);
	}

	private void addMoreCourseForStudent(AppDAO appDAO) {
		int id=2;

		Student student=appDAO.findStudentAndCourseByStudentId(id);

		Course course=new Course("Advance Java");
		Course course2=new Course("Advance python");
		student.addCourse(course);
		student.addCourse(course2);
		appDAO.update(student);
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int id=2;

		Student student=appDAO.findStudentAndCourseByStudentId(id);

		System.out.println("Student: "+student);

		System.out.println("Courses: "+student.getCourses());
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int id=10;

		Course tempCourse=appDAO.findCourseAndStudentByCourseId(id);

		System.out.println("load course: "+tempCourse);
		System.out.println("students: "+tempCourse.getStudents());

	}

	private void createCourseAndStudent(AppDAO appDAO) {

		Course course1=new Course("maths");


		Student student1=new Student("prince","pansuriya","p@gmail.com");
		Student student2=new Student("shivam","pansuriya","s@gmail.com");

		course1.addStudent(student1);
		course1.addStudent(student2);

		appDAO.save(course1);
	}

	private void deleteCourseAndReview(AppDAO appDAO) {

		//here we have cascade all so review will automatically get deleted
		int id=10;
		appDAO.deleteCourseById(id);

	}

	private void retrieveCourseAndReview(AppDAO appDAO) {

		int id=10;
		Course course=appDAO.findCourseAndReviewByCourseId(id);

		System.out.println(course);

		System.out.println(course.getReviews());
	}

	private void CreateCourseAndReview(AppDAO appDAO) {

		Course course=new Course("Aptitude");
		Review review1=new Review("very nice");
		Review review2=new Review("good");

		course.addReview(review1);
		course.addReview(review2);

		appDAO.save(course);

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
