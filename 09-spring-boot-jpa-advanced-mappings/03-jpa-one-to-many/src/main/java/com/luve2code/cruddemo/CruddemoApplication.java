package com.luve2code.cruddemo;

import com.luve2code.cruddemo.dao.AppDAO;
import com.luve2code.cruddemo.entity.Course;
import com.luve2code.cruddemo.entity.Instructor;
import com.luve2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		var tempInstructor = new Instructor("Susan", "Public", "susan.public@luve2code");

		var tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Video Games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// Create some courses
		/*Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");*/

		List<Course> courses = List.of(
				new Course("Air Guitar - The Ultimate Guide"),
				new Course("The Pinball Masterclass")
		);

		for (Course course : courses){
			tempInstructor.add(course);
		}

		// NOTE: This will ALSO save the courses
		// Because of CascadeType.PERSIST

		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);
		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail = " + tempInstructorDetail);

		System.out.println("The associated instructor: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("The associated instructorDetail only: " + tempInstructor.getInstructorDetail());


	}

	private void createInstructor(AppDAO appDAO) {

		/*var tempInstructor = new Instructor("Chad", "Darby", "darby@luve2code");

		var tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube.com", "Luv 2 code!!!");*/

		var tempInstructor = new Instructor("Madhu", "Patel", "madhu@luve2code");

		var tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube.com", "Guitar");

		// Associate the objects
		// NOTE: This will ALSO save the details object
		// Because of CascadeType.ALL
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
