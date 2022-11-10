package com.JPA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JPA.model.Course;
import com.JPA.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService cservice;

	@GetMapping("/find")
	public List<Course> findAllCourse() {
		return cservice.findAllCourse();
	}

	@PostMapping("/save")
	public Course saveCourse(@RequestBody Course course) {
		return cservice.saveCourse(course);
	}

	@PutMapping("/id/{courseId}")
	public Course findById(@PathVariable int courseId) {

		return cservice.findById(courseId);
	}

	@DeleteMapping("/delete/{courseId}")
	public String deleteById(@PathVariable int courseId) {

		cservice.deleteById(courseId);
		return "record deleted successfully";
	}

	@PutMapping("/update/{courseId}")
	public Course UpdateById(@RequestBody Course course, @PathVariable int courseId) {

		Course c1 = cservice.findById(courseId);
		c1.setCourseId(course.getCourseId());
		c1.setCourseName(course.getCourseName());
		c1.setCfname(course.getCfname());
		c1.setCoursefee(course.getCoursefee());
		return cservice.updateById(c1);
	}

}
