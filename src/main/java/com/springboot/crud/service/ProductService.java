package com.springboot.crud.service;

import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.response.PageDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.response.product.ProductTableResponseDto;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface ProductService {

    ProductResponseDto retrieveProduct(Long code);

    ProductTableResponseDto getProductTableById(Long id);
    PageDto<ProductResponseDto> listProducts(Pageable pageable);

    ProductResponseDto createProduct(ProductNewRequestDto productRequestDto);

    void createListProduct(List<ProductNoSupplierNewRequestDto> products, Supplier supplier);

    ProductResponseDto updateProduct(Long code, ProductNewRequestDto productRequestDto) throws Exception;

    void deleteProduct(Long code) throws Exception;

}
