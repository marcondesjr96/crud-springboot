package com.springboot.crud.convert;

import com.springboot.crud.domain.Product;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNoListProductNewRequestDto;
import com.springboot.crud.dto.response.supplier.SupplierResponseDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierConvert {

    public static SupplierResponseDto supplierToResponseDto(Supplier supplier){
        return SupplierResponseDto.builder()
                .name(supplier.getName())
                .address(supplier.getAddress())
                .contact(supplier.getContact())
                .productList(supplier.getProductList())
                .build();
    }

    public static Supplier supplierDtoToEntity(SupplierNewRequestDto supplierRequestDto){
        return Supplier.builder()
                .cnpj(supplierRequestDto.getCnpj())
                .productList(listProductDtoToEntity(supplierRequestDto.getProductList()))
                .name(supplierRequestDto.getName())
                .contact(supplierRequestDto.getContact())
                .address(supplierRequestDto.getAddress())
                .build();
    }

    public static Supplier supplierDtoToEntityNoListProduct(SupplierNoListProductNewRequestDto supplierDtoNoList){
        return Supplier.builder()
                .contact(supplierDtoNoList.getContact())
                .name(supplierDtoNoList.getName())
                .cnpj(supplierDtoNoList.getCnpj())
                .address(supplierDtoNoList.getAddress())
                .build();
    }


    private static List<Product> listProductDtoToEntity(List<ProductNoSupplierNewRequestDto> productNewRequestDtos){
        List<Product> productList = new ArrayList<>();
        for (ProductNoSupplierNewRequestDto product : productNewRequestDtos){
            Product productEntity = ProductConvert.produtoNoSupplierDtoToDomain(product);
            productList.add(productEntity);
        }
        return productList;

    }

}
