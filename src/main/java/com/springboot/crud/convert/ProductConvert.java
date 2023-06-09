package com.springboot.crud.convert;

import com.springboot.crud.domain.Product;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNoListProductNewRequestDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;

import java.time.LocalDateTime;

public class ProductConvert {

    public static Product produtoDtoToDomain(ProductNewRequestDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .category(productDto.getCategory())
                .supplier(supplierDtoToEntityNoList(productDto.getSupplier()))
                .description(productDto.getDescription())
                .createdIn(LocalDateTime.now())
                .build();
    }

    public static Product produtoNoSupplierDtoToDomain(ProductNoSupplierNewRequestDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .category(productDto.getCategory())
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

    private static Supplier supplierDtoToEntityNoList(SupplierNoListProductNewRequestDto supplierDtoNoList){
        return SupplierConvert.supplierDtoToEntityNoListProduct(supplierDtoNoList);
    }
}
