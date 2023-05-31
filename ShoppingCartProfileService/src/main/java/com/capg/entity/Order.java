package com.capg.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Document(collection= "orders")
public class Order {
	
	@Transient
	public static final String SEQUENCE_NAME="order_sequence";

	@Id
	private Integer orderId;
	

	private String productname;
	

	private Integer quantity;
	

	private double cost;
	
	
}

