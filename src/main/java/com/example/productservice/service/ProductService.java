package com.example.productservice.service;

import com.example.productservice.domain.dto.ProductModel;
import com.example.productservice.domain.entities.Product;
import com.example.productservice.domain.mappers.ProductMapper;
import com.example.productservice.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product createProduct(ProductModel productModel) {
        Product productDb = productMapper.fromModelToDb(productModel);
        return productRepository.save(productDb);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
