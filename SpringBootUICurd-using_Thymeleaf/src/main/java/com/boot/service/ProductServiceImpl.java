package com.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.Repo.ProductRepo;
import com.boot.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo repo;
	@Override
	public Integer saveProduct(Product product) {
		
		double cost=product.getProdCost();
		double discount=cost*5/100;
		double gst=cost*10/100;
		product.setDiscount(discount);
		product.setGst(gst);
		repo.save(product);
		return 1;
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product> list=repo.findAll();
		return list;
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Product getOneProduct(Integer id) {
		Product prod=null;
		Optional<Product> opt=repo.findById(id);
		if(opt.isPresent()) { //avoid NullPointerException
			prod = opt.get();
		}
		return prod;
	}

	@Override
	public void updateProduct(Product product) {
		
		double cost=product.getProdCost();
		double discount=cost*5/100;
		double gst=cost*10/100;
		product.setDiscount(discount);
		product.setGst(gst);
		repo.save(product).getProdId();
		
	}

	@Override
	public boolean isExist(Integer id) {
		
		boolean msg=repo.existsById(id);
		return msg;
	}

}
