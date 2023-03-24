package com.springboot.crud.convert;

import com.springboot.crud.domain.Produto;
import com.springboot.crud.dto.ProdutoDTO;
import com.springboot.crud.dto.ProdutoFormDTO;

public class ProdutoConvert {

    public static Produto produtoDtoToDomain(ProdutoFormDTO produtoDTO){
       return Produto.builder()
                .nome(produtoDTO.getNome())
                .valor(produtoDTO.getValor())
                .quantidade(produtoDTO.getQuantidade())
                .build();
    }

    public static ProdutoDTO produtoDomainToDto(Produto produto){
        return ProdutoDTO.builder()
                .nome(produto.getNome())
                .valor(produto.getValor())
                .build();
    }
}
