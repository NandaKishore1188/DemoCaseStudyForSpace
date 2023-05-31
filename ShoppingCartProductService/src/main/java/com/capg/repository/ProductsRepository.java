package com.capg.repository;

import java.util.Optional;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Product;


@Repository
public interface ProductsRepository extends MongoRepository<Product, Integer> {

	Optional<Product> findByproductName(String productName);
}
