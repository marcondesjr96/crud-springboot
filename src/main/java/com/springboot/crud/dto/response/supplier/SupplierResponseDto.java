package com.springboot.crud.dto.response.supplier;

import com.springboot.crud.domain.Product;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponseDto implements Serializable {

    private String name;
    private String address;
    private String contact;
    private List<ProductResponseDto> productList;
}
