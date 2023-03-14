package com.example.productservice.web;

import com.example.productservice.domain.dto.ProductDetails;
import com.example.productservice.domain.dto.ProductModel;
import com.example.productservice.domain.entities.Product;
import com.example.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    private ProductDetails createProduct(@RequestBody ProductModel productModel){
        return productService.createProduct(productModel);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    private List<ProductDetails> getAllProducts(){
        return productService.getAllProducts();
    }
}
