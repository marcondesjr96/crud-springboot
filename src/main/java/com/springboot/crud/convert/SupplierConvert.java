package com.springboot.crud.convert;

import com.springboot.crud.domain.Product;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNoListProductNewRequestDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.response.supplier.SupplierResponseDto;

import java.util.ArrayList;
import java.util.List;

public class SupplierConvert {

    public static SupplierResponseDto supplierToResponseDto(Supplier supplier){
        return SupplierResponseDto.builder()
                .name(supplier.getName())
                .address(supplier.getAddress())
                .contact(supplier.getContact())
                .productList(listProductToDto(supplier.getProductList()))
                .build();
    }

    public static Supplier supplierDtoToEntity(SupplierNewRequestDto supplierRequestDto){
        return Supplier.builder()
                .cnpj(supplierRequestDto.getCnpj())
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


    private static List<ProductResponseDto> listProductToDto(List<Product> products){
        List<ProductResponseDto> productList = new ArrayList<>();
        for (Product product : products){
            ProductResponseDto productDto = ProductConvert.produtoDomainToDto(product);
            productList.add(productDto);
        }
        return productList;

    }

}
