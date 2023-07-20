package com.edith.cruddemo;

import com.edith.cruddemo.dao.AppDaoImp;
import com.edith.cruddemo.entity.Course;
import com.edith.cruddemo.entity.Instructor;
import com.edith.cruddemo.entity.InstructorDetails;
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
    CommandLineRunner commandLineRunner(AppDaoImp appDaoImp){

		return run -> {
//			createIntructor(appDaoImp);
//			findById(appDaoImp);
//			findInstructorDetails(appDaoImp);
//			createIntructorAndCourse(appDaoImp);
//			getCoursesByIntructorid(appDaoImp);
			getInstructorWhithCourcesById(appDaoImp);
		};

	}

	private void getInstructorWhithCourcesById(AppDaoImp appDaoImp) {

		Instructor instructor = appDaoImp.findIntructorByIdJoinFetch(2);

		System.out.println("Cources the " + instructor.getCourses());
	}

	private void getCoursesByIntructorid(AppDaoImp appDaoImp) {

		Instructor instructor = appDaoImp.findById(2);
		List<Course> courses = appDaoImp.getCoursesByIntructorId(instructor.getId());
		instructor.setCourses(courses);
		System.out.println("List of coueses " +  instructor.getCourses());
	}

	private void createIntructorAndCourse(AppDaoImp appDaoImp) {

		Instructor instructor= new Instructor("Rishabh","Mishra", "Mishra@gmail.com");
		InstructorDetails instructorDetails= new InstructorDetails("http://youtube2.com","teaching");
		instructor.setInstructorDetails(instructorDetails);

		Course course = new Course("Mathematics");
		Course course1= new Course("Physics");

		instructor.add(course);
		instructor.add(course1);

		appDaoImp.save(instructor);
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

	void findInstructorDetails(AppDaoImp appDaoImp){
		int theid=1;
		InstructorDetails instructorDetails= appDaoImp.findInstructorDetailsById(theid);

		System.out.println("Instructor Details " + instructorDetails);
		System.out.println("Instructor" + instructorDetails.getInstructor());
	}

}
