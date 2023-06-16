package com.springboot.crud.dto.response.product;

import com.springboot.crud.dto.response.supplier.SupplierResponseDto;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductTableResponseDto {

    private String name;
    private double price;
    private SupplierResponseDto supplier;



}
