package com.JPA.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JPA.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
