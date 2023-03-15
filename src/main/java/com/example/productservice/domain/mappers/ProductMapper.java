package com.example.productservice.domain.mappers;

import com.example.productservice.domain.dto.ProductDetails;
import com.example.productservice.domain.dto.ProductModel;
import com.example.productservice.domain.entities.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromModelToDb(ProductModel productModel);

    ProductDetails fromDbToDetails(Product result);
    List<ProductDetails> fromDbToDetails(List<Product> result);
}
