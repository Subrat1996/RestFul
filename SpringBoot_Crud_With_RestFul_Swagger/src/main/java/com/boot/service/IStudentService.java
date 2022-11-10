package com.boot.service;

import java.util.List;

import com.boot.model.Student;

public interface IStudentService {

	Integer saveStudent(Student s);
	List<Student> findAllStudents();
	Student findOneStudent(Integer id);
	void deleteStudent(Integer id);
	void updateStudent(Student s);
	boolean isStudentExist(Integer id);
}
