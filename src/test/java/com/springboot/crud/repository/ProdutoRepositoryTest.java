package com.springboot.crud.repository;

import com.springboot.crud.domain.Produto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@DisplayName("Tests for Produto Repository")
class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    void save_PersistProduto(){
        Produto produtoToBeSaved = createProduto();
        Produto produtoSaved = produtoRepository.save(produtoToBeSaved);
        Assertions.assertThat(produtoSaved).isNotNull();
        Assertions.assertThat(produtoSaved.getCodigo()).isNotNull();
        Assertions.assertThat(produtoSaved.getNome()).isEqualTo(produtoToBeSaved.getNome());


    }
    private Produto createProduto(){
        return Produto.builder()
                .nome("Celular")
                .valor(150.00)
                .quantidade(2)
                .criadoEm(LocalDateTime.now())
                .descricao("Lorem")
                .fornecedor("Sicrano")
                .categoria("Eletronico")
                .build();
    }

}