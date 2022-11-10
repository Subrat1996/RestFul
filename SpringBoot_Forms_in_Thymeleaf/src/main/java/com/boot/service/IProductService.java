package com.boot.service;

import java.util.List;

import com.boot.model.Product;

public interface IProductService {

	// save product
	public Integer saveProduct(Product product);

	// fetch all products
	public List<Product> getAllProducts();

	// delete product by id
	public void deleteProduct(Integer id);

	// fetch one product
	public Product getOneProduct(Integer id);

	// update product
	public void updateProduct(Product product);

	// is record exist by given id
	public boolean isExist(Integer id);

}
