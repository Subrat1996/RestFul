package com.boot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Student;
import com.boot.repo.StudentRepository;
import com.boot.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Integer saveStudent(Student s) {
		Integer id=repo.save(s).getStdId();
		return id;
	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> list=repo.findAll();
		return list;
	}

	@Override
	public Student findOneStudent(Integer id) {
		Student s=null;
		Optional<Student> opt=repo.findById(id);
		if(opt.isPresent()) {
			s=opt.get();
		}
		return s;
	}

	@Override
	public void deleteStudent(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public void updateStudent(Student s) {
		repo.save(s);
	}
	
	@Override
	public boolean isStudentExist(Integer id) {
		boolean status=repo.existsById(id);
		return status;
	}
}
