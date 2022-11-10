package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Emloyee;

@RestController
public class MyController {

	
	@RequestMapping("/hii")
	public String Hii() {
		return "hiiii";
	}
	
	@RequestMapping("/find")
	public List<Emloyee> getAll(){
		List<Emloyee> list=new ArrayList();
		list.add(new Emloyee(1,"aa"));
		list.add(new Emloyee(2,"bbb"));
		return list;
	}
}

