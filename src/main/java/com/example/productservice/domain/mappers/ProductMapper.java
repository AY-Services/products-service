package com.example.productservice.domain.mappers;

import com.example.productservice.domain.dto.ProductModel;
import com.example.productservice.domain.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product fromModelToDb(ProductModel productModel);
}
