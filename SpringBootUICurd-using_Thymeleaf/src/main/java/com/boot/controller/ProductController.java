package com.boot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.model.Product;
import com.boot.service.ProductService;


@Controller
@RequestMapping("/product") //optional
public class ProductController {
	@Autowired
	private ProductService service; //HAS-A

	//1. Get All Products to UI
	@RequestMapping("/all")
	public String showAll(Model model) {
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductsData";
	}
	//2. Delete record by ID
	@RequestMapping("/delete/{id}") //Here { } indicates dynamic path
	public String deleteOne(
			@PathVariable("id")Integer id,   //key name must be same as Dynamic Path
			Model model
			) 
	{
		service.deleteProduct(id);
		model.addAttribute("message", "Product '"+id+"' Deleted");
		//send new data to UI
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		return "ProductsData";
	}
}