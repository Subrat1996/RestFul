package com.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmpController {

	@RequestMapping("/show")
	public String register() {
		
		return "show_reg";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String save(@ModelAttribute Employee employee,Model model) {
		
		model.addAttribute("emp",employee);
		return "data";
	}
}
