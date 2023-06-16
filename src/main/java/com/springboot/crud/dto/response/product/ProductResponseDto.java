package com.springboot.crud.dto.response.product;

import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto implements Serializable {

    private String name;
    private double price;
    private String category;
    private int stock;
    private String description;

}
