package com.springboot.crud.repository;

import com.springboot.crud.domain.Produto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Assertions.assertThat(produtoSaved.getDescricao()).isEqualTo(produtoToBeSaved.getDescricao());
        Assertions.assertThat(produtoSaved.getValor()).isEqualTo(produtoToBeSaved.getValor());
        Assertions.assertThat(produtoSaved.getQuantidade()).isEqualTo(produtoToBeSaved.getQuantidade());
        Assertions.assertThat(produtoSaved.getCategoria()).isEqualTo(produtoToBeSaved.getCategoria());
        Assertions.assertThat(produtoSaved.getFornecedor()).isEqualTo(produtoToBeSaved.getFornecedor());
        Assertions.assertThat(produtoSaved.getCriadoEm()).isEqualTo(produtoToBeSaved.getCriadoEm());

    }

    @Test
    void save_UpdateProduto(){
        Produto produtoToBeSaved = createProduto();
        Produto produtoSaved = produtoRepository.save(produtoToBeSaved);

        produtoSaved.setNome("Smartphone");

        Produto produtoUpdated = this.produtoRepository.save(produtoSaved);

        Assertions.assertThat(produtoUpdated).isNotNull();
        Assertions.assertThat(produtoUpdated.getCodigo()).isNotNull();
        Assertions.assertThat(produtoUpdated.getNome()).isEqualTo(produtoToBeSaved.getNome());
        Assertions.assertThat(produtoUpdated.getDescricao()).isEqualTo(produtoToBeSaved.getDescricao());
        Assertions.assertThat(produtoUpdated.getValor()).isEqualTo(produtoToBeSaved.getValor());
        Assertions.assertThat(produtoUpdated.getQuantidade()).isEqualTo(produtoToBeSaved.getQuantidade());
        Assertions.assertThat(produtoUpdated.getCategoria()).isEqualTo(produtoToBeSaved.getCategoria());
        Assertions.assertThat(produtoUpdated.getFornecedor()).isEqualTo(produtoToBeSaved.getFornecedor());
        Assertions.assertThat(produtoUpdated.getCriadoEm()).isEqualTo(produtoToBeSaved.getCriadoEm());

    }

    @Test
    void delete_RemovesProduto(){
        Produto produtoToBeSaved = createProduto();
        Produto produtoSaved = produtoRepository.save(produtoToBeSaved);

        this.produtoRepository.delete(produtoSaved);

        Optional<Produto> produtoOptional = this.produtoRepository.findById(produtoSaved.getCodigo());

        Assertions.assertThat(produtoOptional).isEmpty();

    }

    @Test
    void findAll_ReturnListOfProdutos(){

        Produto produtoToBeSaved = createProduto();
        Produto produtoSaved = produtoRepository.save(produtoToBeSaved);

        List<Produto> produtoList = produtoRepository.findAll();

        Assertions.assertThat(produtoList).isNotEmpty();

        Assertions.assertThat(produtoList).contains(produtoSaved);

    }

    @Test
    void findById_ReturnNotFound(){
        Produto produtoToBeSaved = createProduto();

        Optional<Produto> produtoOptional = produtoRepository.findById(0L);

        Assertions.assertThat(produtoOptional).isEmpty();


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