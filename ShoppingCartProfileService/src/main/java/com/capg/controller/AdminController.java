package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
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
import org.springframework.web.client.RestTemplate;

import com.capg.dto.UserProfileDTO;
import com.capg.entity.Product;
import com.capg.entity.UserProfile;
import com.capg.exception.ResourceNotFoundException;
import com.capg.service.ProfileService;
import com.capg.service.SequenceGeneratorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

	@Autowired
	ProfileService profileService;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private SequenceGeneratorService service;

	@GetMapping("/users/getall")
	public List<UserProfileDTO> userProfile() {
		return profileService.getAllProfiles();
	}

	@GetMapping("/users/get/{profileId}")
	public UserProfileDTO byProfileId(@PathVariable Integer profileId) {
		return profileService.getByProfileId(profileId);
	}

	// the following code is for the update method in mongoDB
	@PutMapping("/users/update/{profileId}")
	public ResponseEntity<UserProfile> update(@PathVariable Integer profileId, @RequestBody UserProfile user)
			throws Exception {
		user.setProfileId(profileId);
		return ResponseEntity.ok().body(this.profileService.updateProfile(user));
	}

	@DeleteMapping("/users/delete/{profileId}")
	public String delete(@PathVariable Integer profileId) {
		profileService.deleteUserProfile(profileId);
		return "Customer With ID " + profileId + " Was Deleted Successfully!!";
	}

	@DeleteMapping("/users/deleteAll")
	public String deleteAll() {
		profileService.deleteAllUserProfiles();
		return "All Customers Deleted Successfully!!";
	}

	@GetMapping("/users/getbymail/{emailId}")
	public UserProfileDTO customerBymail(@PathVariable String emailId) {
		return profileService.getByMail(emailId);
	}

	// *******************************************Products******************************************************************
	// saving products by admin
	@PostMapping("/products/save")
	public ResponseEntity<Product> saveProducts(@RequestBody Product product) {

		Product product1 = new Product(product.getProductId(), product.getProductName(), product.getProductPrice(),
				product.getProductQuantity());
		Product response = restTemplate.postForObject("http://ShoppingCartProductService/products/save", product1,
				Product.class);
		return ResponseEntity.ok(response);

	}

	// deleting any product by admin
	@DeleteMapping("/delete/{productId}")
	public String deleteDrugsData(@PathVariable("productId") int productId) throws Exception {

		if (productId != 0) {
			restTemplate.delete("http://ShoppingCartProductService/products/delete" + productId);
			return "Deleted Succesfully";
		} else {
			throw new Exception("No Id Found");
		}

	}

	// getting all the products by admin
	@GetMapping("/products/getall")
	public Product[] getAllProducts() throws ResourceNotFoundException {
		ResponseEntity<Product[]> response = restTemplate
				.getForEntity("http://ShoppingCartProductService/products/getall", Product[].class);
		Product[] product = response.getBody();
		return (product);
	}

	@RequestMapping("/byid/{productId}")
	public Product getProductById(@PathVariable("productId") String productId) {
		return restTemplate.getForObject("http://ShoppingCartProductService/products/get/" + productId, Product.class);
	}

	// updating any product data by admin
	@PutMapping("/products/update/{productId}")
	public Product updateProductsData(@RequestBody Product product, @PathVariable("productId") int productId) {
		RequestEntity<Product> request = RequestEntity
				.put("http://ShoppingCartProductService/products/update/" + productId)
				.accept(MediaType.APPLICATION_JSON).body(product);
		ResponseEntity<Product> response = restTemplate.exchange(request, Product.class);
		Product product1 = response.getBody();
		return product1;
	}

}
