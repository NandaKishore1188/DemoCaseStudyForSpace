package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.dto.ProductDTO;
import com.capg.entity.Product;


public interface ProductService {
	
	ProductDTO addProducts(ProductDTO productsDTO);
 
	List<ProductDTO> getAllProducts();
	
	ProductDTO getProductById(Integer productId);
	
	ProductDTO getProductByName(String productName);
	
//	 public Optional<Product> getProductByName(String productName);
	
	Product updateProduct(Product product) throws Exception;
	
	void deleteProductById(Integer productId);
	
}





