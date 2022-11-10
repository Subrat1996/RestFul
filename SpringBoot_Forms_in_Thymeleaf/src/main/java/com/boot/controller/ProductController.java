package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.model.Product;
import com.boot.service.IProductService;

@Controller
@RequestMapping("/product") //optional
public class ProductController {
	@Autowired
	private IProductService service; //HAS-A

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
	
	//3. Display Register page
	@RequestMapping("/reg")
	public String showReg(Model model) {
		//FORM BACKING OBJECT
		model.addAttribute("product", new Product());
		/*
		Product p=new Product();
		p.setProdCode("ABC");
		model.addAttribute("product",p);
		*/
		return "ProductRegister";
	}
	//4. on click submit read Form Data and save
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(
			@ModelAttribute Product product,  //reading form data
			Model model //send data to UI back
			) 
	{
		//service save
		Integer id=service.saveProduct(product);
		model.addAttribute("message", "Product '"+id+"' saved");
		//FORM BACKING OBJECT
		model.addAttribute("product", new Product());

		return "ProductRegister";
	}
	
	//5. Show Edit Page
	@RequestMapping("/edit/{id}")
	public String showEdit(
			@PathVariable("id")Integer id,
			Model model
			) 
	{
		//load Model class object from DB by using Id
		Product p=service.getOneProduct(id);
		//send to UI as Form Backing object
		model.addAttribute("product", p);
		
		return "ProductEdit";
	}
	
	//6. on click update button perform same.
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String update(
			@ModelAttribute Product product,
			Model model)
	{
		//update data in DB
		service.updateProduct(product);
		model.addAttribute("message", "Product '"+product.getProdId()+"' updated");

		//send new data to UI
		List<Product> list=service.getAllProducts();
		model.addAttribute("list", list);
		
		return "ProductsData";
	}
}
