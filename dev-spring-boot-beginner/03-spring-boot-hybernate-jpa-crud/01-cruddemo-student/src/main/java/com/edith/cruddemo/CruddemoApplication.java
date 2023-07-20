package com.edith.cruddemo;

import com.edith.cruddemo.dao.StudentDao;
import com.edith.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}
	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner -> {
//			 SaveStudentDetails(studentDao);
			FindStudentDetails(studentDao);
			findAll(studentDao);
		};
	}

	void SaveStudentDetails(StudentDao studentDao){
		System.out.println("Saving student details ");
		Student student = new Student("Prateek", "Raman", "pr@gmail.com");

		studentDao.Save(student);

		System.out.println("changes are saved succssfully");
	}

	void FindStudentDetails(StudentDao studentDao){
		System.out.println("Creating a sudent object ");
		Student student = new Student("kshitij","Patel", "kshitij@gmail.com");

		studentDao.Save(student);

		System.out.println("Getting student Id from Object");
		int StuId = student.getId();
		System.out.println("StudentId is " + StuId);

		Student st = studentDao.FindById(StuId);
		System.out.println("Student Details " + st.getFirstName() + " " + st.getLastName() + " " + st.getEmail());

	}

	void findAll(StudentDao studentDao){

		List<Student> students = studentDao.findAll();
		System.out.println("Student list " + students.toString());
	}
}
