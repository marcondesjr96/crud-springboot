package com.springboot.crud.dto.request;

import com.springboot.crud.domain.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductNewRequestDto implements Serializable {

    private String name;
    private double price;
    private int stock;
    private String category;
    private SupplierNewRequestDto supplier;
    private String description;
    private LocalDateTime createdIn;

}
