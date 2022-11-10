package com.boot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(repo.getClass());
		repo.save(new Student(10,"subu","RIT"));
		repo.save(new Student(11,"pabu","VD"));
		repo.save(new Student(12,"jitu","GIT"));
		
		List<Student> list=repo.findAll();
		list.forEach(System.out::println);
		
		repo.deleteById(11);
		
	}

}
