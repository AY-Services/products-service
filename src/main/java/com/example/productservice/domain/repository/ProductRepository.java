package com.example.productservice.domain.repository;

import com.example.productservice.domain.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductRepository extends MongoRepository<Product, String> {
}
