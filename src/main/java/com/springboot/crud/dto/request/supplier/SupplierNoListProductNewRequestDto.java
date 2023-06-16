package com.springboot.crud.dto.request.supplier;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierNoListProductNewRequestDto{

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @NotEmpty
    private String cnpj;

    @NotEmpty
    private String contact;
}
