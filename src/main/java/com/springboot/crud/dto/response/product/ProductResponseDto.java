package com.springboot.crud.dto.response.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto implements Serializable {

    private String name;
    private double price;
    private String category;
    private int stock;
    private String description;

}
