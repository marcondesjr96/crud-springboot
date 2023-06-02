package com.springboot.crud.convert;

import com.springboot.crud.domain.Product;
import com.springboot.crud.dto.ProductResponseDto;
import com.springboot.crud.dto.ProductRequestDto;

import java.time.LocalDateTime;

public class ProductConvert {

    public static Product produtoDtoToDomain(ProductRequestDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .category(productDto.getCategory())
                .supplier(productDto.getSupplier())
                .description(productDto.getDescription())
                .createdIn(LocalDateTime.now())
                .build();
    }

    public static ProductResponseDto produtoDomainToDto(Product product) {
        return ProductResponseDto.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .description(product.getDescription())
                .stock(product.getStock())
                .build();
    }
}
