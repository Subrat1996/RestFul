package com.JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.JPA.model.Course;
import com.JPA.service.CourseService;
import com.JPA.service.CourseServiceImpl;

@SpringBootApplication
public class SpringBootDemo1Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemo1Application.class, args);
		/*
		 * CourseService service = context.getBean(CourseServiceImpl.class); Course
		 * course = new Course(); course.setCourseName("spring");
		 * course.setCfname("nataraj"); course.setCoursefee(5000.0);
		 * 
		 * Course c1=service.saveCourse(course); System.out.println(c1);
		 */
	}

}
