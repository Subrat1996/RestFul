package in.boot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.boot.model.Employee;
import in.boot.repo.EmployeeRepo;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;
	
	@RequestMapping("/employee")
	public List<Employee> get(){
		
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public String save( @Valid @RequestBody Employee employee) {
		
		repo.save(employee);
		return "data inserted";
	}
}
