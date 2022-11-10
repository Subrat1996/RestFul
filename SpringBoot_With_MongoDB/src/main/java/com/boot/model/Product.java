package com.boot.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Product {

	@Id
	private String id;
	private String prodCode;
	private Double prodCost;
	private String prodVendor;
}
