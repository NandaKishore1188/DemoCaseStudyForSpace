package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dto.ProductDTO;
import com.capg.entity.Product;
import com.capg.service.ProductService;
import com.capg.service.SequenceGeneratorService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private SequenceGeneratorService service;

	@PostMapping("/save")
	public ResponseEntity<ProductDTO> save(@Valid @RequestBody ProductDTO prod) {
		prod.setProductId(service.getSequenceNumber(Product.SEQUENCE_NAME));
		return new ResponseEntity<ProductDTO>(productService.addProducts(prod),HttpStatus.CREATED);
	}

	@GetMapping("/getall")
	public List<ProductDTO> product(){
		return productService.getAllProducts();
	}

	@GetMapping("/get/{productId}")
	public ProductDTO byProductId(@PathVariable Integer productId) {
		return productService.getProductById(productId);
	}

	@GetMapping("/getbyname/{productName}")
	public ProductDTO productByName(@PathVariable String productName) {
		return productService.getProductByName(productName);
	}

	@PutMapping("/update/{productId}")
	public ResponseEntity<Product> update(@PathVariable Integer productId,@RequestBody Product prod) throws Exception{
		prod.setProductId(productId);
		return  ResponseEntity.ok().body(this.productService.updateProduct(prod));
	}

	@DeleteMapping("/delete/{productId}")
	public String delete(@PathVariable Integer productId) {
		productService.deleteProductById(productId);
		return "Customer With ID "+productId+" Was Deleted Successfully!!";
	}
}
