package com.capg.dto;

import java.util.Map;

import com.capg.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {


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

	public ProductDTO(Product product) {
		this.productId = product.getProductId();
//		this.productType =  product.getProductType();
		this.productName =  product.getProductName();
//		this.category =  product.getCategory();
//		this.rating =  product.getRating();
//		this.review =  product.getReview();
		this.productPrice =  product.getProductPrice();
		this.productQuantity=product.getProductQuantity();
		//		this.description =  product.getDescription();
	}
	
	
}
