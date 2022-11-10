package com.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@RequestMapping("/reg")
	public String showPage() {
		return "Register";
	}
	
	//2. Read Form Data and display at UI
	@RequestMapping(value="/save",method =RequestMethod.POST)
	public String readData(
			@ModelAttribute Employee employee,
			Model model
			) 
	{
		model.addAttribute("ob", employee);
		return "Data";
	}

}
