package com.springboot.crud.dto.response.supplier;

import com.springboot.crud.domain.Product;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponseDto{

    private String name;
    private String address;
    private String contact;
    private List<ProductResponseDto> productList;
}
