package com.springboot.crud.service;

import com.springboot.crud.dto.ProductResponseDto;
import com.springboot.crud.dto.ProductRequestDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto retrieveProduct(Long code);

    List<ProductResponseDto> listProducts();

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto updateProduct(Long code, ProductRequestDto productRequestDto) throws Exception;

    void deleteProduct(Long code) throws Exception;

}
