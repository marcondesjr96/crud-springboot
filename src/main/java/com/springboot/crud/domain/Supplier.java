package com.springboot.crud.domain;

import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String cnpj;

    @Column(nullable = false)
    private String contact;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Product> productList;


}
