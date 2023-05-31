package com.capg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@ComponentScan(basePackages="com.capg.controller")
@ComponentScan(basePackages="com.capg.dto")
@ComponentScan(basePackages="com.capg.repository")
@ComponentScan(basePackages="com.capg.service")
@ComponentScan(basePackages="com.capg.entity")
@ComponentScan(basePackages="com.capg.security")
@EnableMongoRepositories
@EnableEurekaClient
public class ShoppingCartProfileServiceApplication {

	@Bean 
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartProfileServiceApplication.class, args);
	}



}





//@Bean
//@LoadBalanced
//public RestTemplate getRestTemplate() {
//    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//    clientHttpRequestFactory.setConnectTimeout(3000);
//    return new RestTemplate(clientHttpRequestFactory);
//}