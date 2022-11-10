package com.boot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.boot.repo.ProductRepository;
@Component
public class DataTestRunner implements CommandLineRunner{

	@Autowired
	private ProductRepository repo;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(repo.getClass().getName());
		System.out.println("Done");
	}

}
