package com.edith.cruddemo;

import com.edith.cruddemo.dao.AppDaoImp;
import com.edith.cruddemo.entity.Instructor;
import com.edith.cruddemo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);

	}

	@Bean
    CommandLineRunner commandLineRunner(AppDaoImp appDaoImp){

		return run -> {
			createIntructor(appDaoImp);
			findById(appDaoImp);
		};
	}

	void  createIntructor(AppDaoImp appDaoImp){
//		Instructor instructor= new Instructor("manish","Mishra", "manish@gmail.com");
//		InstructorDetails instructorDetails= new InstructorDetails("youtube.com","managering");

		Instructor instructor= new Instructor("manish22","Mishra22", "manish22@gmail.com");
		InstructorDetails instructorDetails= new InstructorDetails("youtube2.com","managering2");
		instructor.setInstructorDetails(instructorDetails);

		appDaoImp.save(instructor);
	}

	void findById(AppDaoImp appDaoImp){
		int id=1;
		Instructor instructor = appDaoImp.findById(id);

		System.out.println("Insturctor" + instructor);
		System.out.println("Instructor details" + instructor.getInstructorDetails());
	}

}
