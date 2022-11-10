package com.boot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmpDataController {

	@RequestMapping("/show")
	public String showEmp(Model model) {
		Employee emp=new Employee();
		emp.setEmpId(1007);
		emp.setEmpName("subrat");
		emp.setDept("DL Build");
		
		model.addAttribute("employee",emp);
		return "views";
	}
}
