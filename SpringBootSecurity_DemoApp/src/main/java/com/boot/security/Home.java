package com.boot.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
	
	@GetMapping("/")
	public String displayMsg() {
		
		return "Hello!....Welcome to Spring Boot Security";
	}
	
	

}
