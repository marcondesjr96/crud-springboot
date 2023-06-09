package com.springboot.crud.dto.request.supplier;

import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierNewRequestDto implements Serializable {

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
