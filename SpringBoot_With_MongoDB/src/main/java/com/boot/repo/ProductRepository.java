package com.boot.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.boot.model.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

}
