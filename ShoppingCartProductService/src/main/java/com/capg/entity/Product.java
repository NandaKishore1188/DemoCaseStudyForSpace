package com.capg.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.capg.dto.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection= "products")
public class Product {
	
	@Transient
	public static String SEQUENCE_NAME;

	@Id
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

	public Product(ProductDTO productDTO) {
		this.productId = productDTO.getProductId();
//		this.productType = productDTO.getProductType();
		this.productName = productDTO.getProductName();
//		this.category = productDTO.getCategory();
//		this.rating = productDTO.getRating();
//		this.review = productDTO.getReview();
		this.productPrice = productDTO.getProductPrice();
		
		this.productQuantity=productDTO.getProductQuantity();
//		this.description = productDTO.getDescription();
	}
	

}
