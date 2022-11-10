package com.boot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.model.Product;
import com.boot.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping("/register")
	public String show() {
		
		return "show_register";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Product product,Model model) {
		
		Integer id=0;
		id=service.saveProduct(product);
		String msg="product '"+id+"'saved";
		model.addAttribute("message", msg);
		return "show_register";
	}
	@RequestMapping("/all")
	public String fetchAllData(Model model) {
		List<Product> list=service.getAllProducts();
		model.addAttribute("list",list);
		return "show_data";
	}
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("pid")Integer id,Model model) {
		
		service.deleteProduct(id);
		model.addAttribute("message","product '"+id+"'deleeted");
		List<Product> list=service.getAllProducts();
		model.addAttribute("list",list);
		return "show_data";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("pid")Integer id,Model model) {
		Product p=service.getOneProduct(id);
		model.addAttribute("ob",p);
		return "product_edit";
	}
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateOne(@ModelAttribute Product product,Model model) {
		
		service.updateProduct(product);
		model.addAttribute("message","Product '"+product.getProdId()+"' updated");
		List<Product> list=service.getAllProducts();
		model.addAttribute("list",list);
		return "show_data";
	}
}
