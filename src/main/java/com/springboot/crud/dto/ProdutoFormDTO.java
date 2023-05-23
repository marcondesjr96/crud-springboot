package com.springboot.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoFormDTO implements Serializable {

    private String nome;
    private double valor;
    private int quantidade;
}
