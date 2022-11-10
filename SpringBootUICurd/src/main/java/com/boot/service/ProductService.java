package com.boot.service;

import java.util.List;

import com.boot.model.Product;

public interface ProductService {

	public Integer saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public void deleteProduct(Integer id);
	
	public Product getOneProduct(Integer id);
	
	public void updateProduct(Product product);
	
	public boolean isExist(Integer id);
  
}
