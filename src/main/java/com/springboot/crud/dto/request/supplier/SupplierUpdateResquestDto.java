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
public class SupplierUpdateResquestDto implements Serializable {


    private String name;

    private String address;

    private String contact;

}
