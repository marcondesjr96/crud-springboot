package com.springboot.crud.convert;

import com.springboot.crud.domain.Produto;
import com.springboot.crud.dto.ProdutoDTO;
import com.springboot.crud.dto.ProdutoFormDTO;

import java.time.LocalDateTime;

public class ProdutoConvert {

    public static Produto produtoDtoToDomain(ProdutoFormDTO produtoDTO) {
        return Produto.builder()
                .nome(produtoDTO.getNome())
                .valor(produtoDTO.getValor())
                .quantidade(produtoDTO.getQuantidade())
                .categoria(produtoDTO.getCategoria())
                .fornecedor(produtoDTO.getFornecedor())
                .descricao(produtoDTO.getDescricao())
                .criadoEm(LocalDateTime.now())
                .build();
    }

    public static ProdutoDTO produtoDomainToDto(Produto produto) {
        return ProdutoDTO.builder()
                .nome(produto.getNome())
                .valor(produto.getValor())
                .categoria(produto.getCategoria())
                .descricao(produto.getDescricao())
                .quantidade(produto.getQuantidade())
                .build();
    }
}
