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
	public CommandLineRunner CommandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMultipleStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);
		};

	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 4;

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;

		Student getStudent = studentDAO.findById(studentId);

		getStudent.setFirstName("Francis");
		getStudent.setLastName("Rashid");
		getStudent.setEmail("Francis.Rashid@gmail.com");

		studentDAO.update(getStudent);

		System.out.println(getStudent.getFirstName());
		System.out.println(getStudent.getLastName());
		System.out.println(getStudent.getEmail());
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("app");

		for(Student tempStudent : theStudents){
			System.out.println(theStudents);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for (Student tempstudent: theStudents) {
			System.out.println(tempstudent);
		}
	}


	public void createMultipleStudent(StudentDAO studentDAO){
		Student tempStudent1 = new Student("rashid","mkoji","rashid.mkoji@gmail.com");
		Student tempStudent2 = new Student("james","raphael","james.raphael@gmail.com");
		Student tempStudent3 = new Student("public","app","public.app@gmail.com");


		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO) {

//		create the student
		System.out.println("creating new student");
		Student tempStudent = new Student("rashid","mkoji","rashid.mkoji@gmail.com");

//		save the student
		System.out.println("saving the student");
		studentDAO.save(tempStudent);

//		display id of created student
		System.out.println("student id is "+ tempStudent.getId());
	}

}
