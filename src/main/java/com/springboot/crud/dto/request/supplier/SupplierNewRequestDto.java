package com.springboot.crud.dto.request.supplier;

import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplierNewRequestDto{

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private String cnpj;

    @NotEmpty
    private String contact;

    private List<ProductNoSupplierNewRequestDto> productList;

}
