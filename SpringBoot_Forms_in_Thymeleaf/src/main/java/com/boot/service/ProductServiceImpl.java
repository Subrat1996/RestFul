package com.boot.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Product;
import com.boot.repo.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepository repo;

	@Override
	public Integer saveProduct(Product product) {
		// calculations
		double cost = product.getProdCost();
		double discount = cost * 5 / 100.0;
		double gst = cost * 12 / 100.0;

		// set data to object
		product.setProdDiscount(discount);
		product.setProdGst(gst);

		Integer id = repo.save(product).getProdId();
		return id;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = repo.findAll();
		// Collections.sort(list, (p1,p2)->p1.getProdId()-p2.getProdId()); //ASC Order
		Collections.sort(list, (p1, p2) -> p2.getProdId() - p1.getProdId()); // DESC Order

		return list;
	}

	@Override
	public void deleteProduct(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public Product getOneProduct(Integer id) {
		Product prod = null;
		Optional<Product> opt = repo.findById(id);
		if (opt.isPresent()) { // avoid NullPointerException
			prod = opt.get();
		}
		return prod;
	}

	@Override
	public void updateProduct(Product product) {
		// calculations
		double cost = product.getProdCost();
		double discount = cost * 5 / 100.0;
		double gst = cost * 12 / 100.0;

		// set data to object
		product.setProdDiscount(discount);
		product.setProdGst(gst);

		// method behaves like update if ID exist
		repo.save(product);
	}

	@Override
	public boolean isExist(Integer id) {
		boolean exist = repo.existsById(id);
		return exist;
	}

}