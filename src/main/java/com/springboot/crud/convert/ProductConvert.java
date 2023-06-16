package com.springboot.crud.convert;

import com.springboot.crud.domain.Product;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNoListProductNewRequestDto;
import com.springboot.crud.dto.response.CustomPageDto;
import com.springboot.crud.dto.response.PageDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.response.product.ProductTableResponseDto;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProductConvert {

    public static Product produtoDtoToDomain(ProductNewRequestDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .category(productDto.getCategory())
                .supplier(supplierDtoToEntityNoList(productDto.getSupplier()))
                .description(productDto.getDescription())
                .build();
    }

    public static Product produtoNoSupplierDtoToDomain(ProductNoSupplierNewRequestDto productDto) {
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .category(productDto.getCategory())
                .description(productDto.getDescription())
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

    public static ProductTableResponseDto toProductTableDto (Product product){
        return ProductTableResponseDto.builder()
                .name(product.getName())
                .supplier(SupplierConvert.supplierToResponseDto(product.getSupplier()))
                .price(product.getPrice())
                .build();

    }

    public static PageDto<ProductResponseDto> toPageProductResponseDto(Page<Product> productPage) {
        PageDto<ProductResponseDto> productResponseDtos = new PageDto<>();

        List<ProductResponseDto> responseDtos = productPage.getContent()
                .stream()
                .map(product -> ProductResponseDto.builder()
                        .name(product.getName())
                        .category(product.getCategory())
                        .stock(product.getStock())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build()).collect(Collectors.toList());

        productResponseDtos.setContent(responseDtos);

        CustomPageDto customPageDto = CustomPageDto.builder()
                .totalPages(productPage.getTotalPages())
                .totalElements(productPage.getTotalElements())
                .number(productPage.getNumber())
                .size(productPage.getSize())
                .build();

        productResponseDtos.setCustomPageDto(customPageDto);
        return productResponseDtos;
    }

    private static Supplier supplierDtoToEntityNoList(SupplierNoListProductNewRequestDto supplierDtoNoList){
        return SupplierConvert.supplierDtoToEntityNoListProduct(supplierDtoNoList);
    }
}
