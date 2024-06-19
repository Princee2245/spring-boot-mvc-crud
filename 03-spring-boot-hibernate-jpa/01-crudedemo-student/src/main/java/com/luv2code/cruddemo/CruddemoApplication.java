package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
			//readStudent(studentDAO);

			//queryforStudent(studentDAO);
			//queryForStudentByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);
			//deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted=studentDAO.deleteAll();
		System.out.println("Delete row  count: "+numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
	int id=1;
	studentDAO.delete(id);

	}

	private void updateStudent(StudentDAO studentDAO) {

		int id=1;
		Student stu=studentDAO.fingById(id);

		stu.setFirstName("Manisha");
		studentDAO.update(stu);

		System.out.println(stu);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		List<Student> theStudent= studentDAO.findByLastName("Pansuriya");

		for(Student s:theStudent){
			System.out.println(s);
		}

	}

	private void queryforStudent(StudentDAO studentDAO) {
		//get a list
		List<Student> stu=studentDAO.findAll();

		//display all
		for(Student s:stu){
			System.out.println(s);
		}

	}

	private void readStudent(StudentDAO studentDAO) {
	Student tempStudent=new Student("Shivam","Pansuriya","z@gmail.com");

	studentDAO.save(tempStudent);
	int id=tempStudent.getId();

	Student student=studentDAO.fingById(id);
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating a student");
		Student tempStudent=new Student("Ritik","Pansuriya","y@gmail.com");

		//save the student object
		System.out.println("Saving object");
		studentDAO.save(tempStudent);

		//display id of saved object
		System.out.println("Save student generated id: "+tempStudent.getId());
	}

}
