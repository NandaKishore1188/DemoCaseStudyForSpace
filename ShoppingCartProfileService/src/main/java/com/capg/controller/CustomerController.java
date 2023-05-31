package com.capg.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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

import com.capg.dto.OrderDTO;
import com.capg.dto.UserProfileDTO;
import com.capg.entity.Order;
import com.capg.entity.Product;
import com.capg.entity.UserProfile;
import com.capg.exception.ResourceNotFoundException;

import com.capg.service.ProfileService;
import com.capg.service.SequenceGeneratorService;


@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private SequenceGeneratorService service;
	
	@Autowired
	 RestTemplate restTemplate;
	
	@GetMapping("/get/{profileId}")
	public UserProfileDTO byProfileId(@PathVariable Integer profileId) {

        return profileService.getByProfileId(profileId);
	}
	
	@PostMapping("/save")
	public ResponseEntity<UserProfileDTO> save(@Valid @RequestBody UserProfileDTO cust) {
		
		cust.setProfileId(service.getSequenceNumber(UserProfile.SEQUENCE_NAME));

		return new ResponseEntity<UserProfileDTO>(profileService.addNewCustomerProfile(cust),HttpStatus.CREATED);
	}
	
	//the following code is for the update method in mongoDB
	@PutMapping("/update/{profileId}")
	public ResponseEntity<UserProfile> update(@PathVariable Integer profileId,@RequestBody UserProfile user) throws Exception{
		user.setProfileId(profileId);
		return  ResponseEntity.ok().body(this.profileService.updateProfile(user));
	}	
	
	@GetMapping("/getbymail/{emailId}")
	public UserProfileDTO customerBymail(@PathVariable String emailId) {
		return profileService.getByMail(emailId);
	}
	
	
	
/***************************getting products data from this profile*********************/
	
	
	
	//Fetching All Products from Product for Customer
	
    @GetMapping("/products/getall")
    public Product[] getAllProducts() throws ResourceNotFoundException{
        ResponseEntity<Product[]> response =
                restTemplate.getForEntity("http://ShoppingCartProductService/products/getall", Product[].class);
        Product[] product = response.getBody();
        return (product);
    }
    
  //Fetching A Product by name from Product for a customer
    @RequestMapping("/byname/{productName}")
    public Product getProductData(@PathVariable("productName")String productName) {
        return restTemplate.getForObject("http://ShoppingCartProductService/products/getbyname/" + productName, Product.class);
    }
    
   


    /************************Ordering the products from here using the resttemplate connection*****************************/
    
    @RequestMapping("/order")
    public ResponseEntity<String> saveOrder(@RequestBody OrderDTO order) throws ResourceNotFoundException{

        String productname = order.getProductname();

        OrderDTO order1 =new OrderDTO(order.getOrderId(), order.getProductname(),order.getQuantity(),order.getCost());

        String s = restTemplate.postForObject("http://ShoppingCartOrdersService/orders/save", order1, String.class);
        return ResponseEntity.ok(s);
        }
    @GetMapping("/order/getall")
    public Order[] getAllOrders() throws ResourceNotFoundException{
        ResponseEntity<Order[]> response =
                restTemplate.getForEntity("http://ShoppingCartOrdersService/orders/getall",Order[].class);
        Order[] order = response.getBody();
        return (order);
    }

    }
	

	