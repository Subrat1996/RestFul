package com.JPA.service;

import java.util.List;

import com.JPA.model.Course;

public interface CourseService {
	
	public List<Course> findAllCourse();
	public Course saveCourse(Course course);
	public void deleteById(int courseId);
	public Course findById(int courseId);
	public Course updateById(Course course);

}
