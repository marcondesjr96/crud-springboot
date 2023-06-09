package com.springboot.crud.dto.request.product;

import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNoListProductNewRequestDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductNewRequestDto implements Serializable {

    @NotEmpty
    private String name;

    @NotNull
    private double price;

    @NotNull
    private int stock;

    @NotEmpty
    private String category;

    @NotNull
    private SupplierNoListProductNewRequestDto supplier;

    @NotEmpty
    private String description;

    @NotNull
    private LocalDateTime createdIn;

}
