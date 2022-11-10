package com.boot.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer prodId;
	private String prodCode;
	private Double prodCost;
	private Double prodDiscount;
	private Double prodGst;
	
	private String prodType;
	private String prodNote;
	private String prodModel;
	
	@ElementCollection
	private List<String> prodDesign;
}
