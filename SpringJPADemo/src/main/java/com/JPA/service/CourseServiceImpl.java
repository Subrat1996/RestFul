package com.JPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JPA.model.Course;
import com.JPA.repo.CourseRepository;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository crepo;
	@Override
	public List<Course> findAllCourse() {
		return crepo.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		return crepo.save(course);
	}

	@Override
	public void deleteById(int courseId) {
		 crepo.deleteById(courseId);
	}

	@Override
	public Course findById(int courseId) {
		return crepo.findById(courseId).orElse(null);
	}

	@Override
	public Course updateById(Course course) {
		return crepo.save(course);
	}

}
