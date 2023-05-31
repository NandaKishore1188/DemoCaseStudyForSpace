package com.capg.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection= "products")
public class Product {
	

//	@Transient
//	public static String SEQUENCE_NAME;
//
//	@Id
	private Integer productId;
	
//	private String productType;
	
	private String productName;
	
//	private String category;
//	
//	private Map<Integer, Double> rating;
//	
//	private Map<Integer, String> review;
	
	private double productPrice;
	
	private int productQuantity;
	
//	private String description;


	

}
