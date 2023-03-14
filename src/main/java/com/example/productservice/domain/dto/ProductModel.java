package com.example.productservice.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductModel {
    private String description;
    private BigDecimal price;
}
