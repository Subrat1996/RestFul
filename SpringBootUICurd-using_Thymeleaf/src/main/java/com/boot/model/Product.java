package com.boot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="ptab")
public class Product {

	@Id
	private Integer prodId;
	private String prodName;
	private Double prodCost;
	private Double gst;
	private Double discount;  
	
}
