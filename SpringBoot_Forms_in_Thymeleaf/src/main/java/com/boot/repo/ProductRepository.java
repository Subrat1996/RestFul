package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
