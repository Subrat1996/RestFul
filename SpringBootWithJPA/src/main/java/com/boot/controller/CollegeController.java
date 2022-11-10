package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.College;
import com.boot.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService cservice;

	@GetMapping("/find")
	public List<College> findAll() {

		return cservice.findAllCollege();
	}

	@PostMapping("/save")
	public College save(@RequestBody College college) {

		return cservice.savecollege(college);
	}

	@GetMapping("/id/{cid}")
	public College findById(@PathVariable int cid) {

		return cservice.findById(cid);
	}

	@DeleteMapping("/delete/{cid}")
	public String deleteById(@PathVariable int cid) {

		cservice.deleteById(cid);
		return "deleted record successfully";
	}

	@PutMapping("/update/{cid}")
	public College updateById(@RequestBody College college, @PathVariable int cid) {

		College c1 = cservice.findById(cid);
		c1.setCid(college.getCid());
		c1.setCname(college.getCname());
		c1.setClocation(college.getClocation());
		c1.setDepartment(college.getDepartment());
		return cservice.updateById(c1);
	}

}
