package com.springboot.crud.repository;

import com.springboot.crud.domain.Product;
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
    private ProductRepository produtoRepository;

    @Test
    void save_PersistProduto(){
        Product produtoToBeSaved = createProduto();
        Product produtoSaved = produtoRepository.save(produtoToBeSaved);

        Assertions.assertThat(produtoSaved).isNotNull();
        Assertions.assertThat(produtoSaved.getId()).isNotNull();
        Assertions.assertThat(produtoSaved.getName()).isEqualTo(produtoToBeSaved.getName());
        Assertions.assertThat(produtoSaved.getDescription()).isEqualTo(produtoToBeSaved.getDescription());
        Assertions.assertThat(produtoSaved.getPrice()).isEqualTo(produtoToBeSaved.getPrice());
        Assertions.assertThat(produtoSaved.getStock()).isEqualTo(produtoToBeSaved.getStock());
        Assertions.assertThat(produtoSaved.getCategory()).isEqualTo(produtoToBeSaved.getCategory());
        Assertions.assertThat(produtoSaved.getSupplier()).isEqualTo(produtoToBeSaved.getSupplier());
        Assertions.assertThat(produtoSaved.getCreatedIn()).isEqualTo(produtoToBeSaved.getCreatedIn());

    }

    @Test
    void save_UpdateProduto(){
        Product produtoToBeSaved = createProduto();
        Product produtoSaved = produtoRepository.save(produtoToBeSaved);

        produtoSaved.setName("Smartphone");

        Product produtoUpdated = this.produtoRepository.save(produtoSaved);

        Assertions.assertThat(produtoUpdated).isNotNull();
        Assertions.assertThat(produtoUpdated.getId()).isNotNull();
        Assertions.assertThat(produtoUpdated.getName()).isEqualTo(produtoToBeSaved.getName());
        Assertions.assertThat(produtoUpdated.getDescription()).isEqualTo(produtoToBeSaved.getDescription());
        Assertions.assertThat(produtoUpdated.getPrice()).isEqualTo(produtoToBeSaved.getPrice());
        Assertions.assertThat(produtoUpdated.getStock()).isEqualTo(produtoToBeSaved.getStock());
        Assertions.assertThat(produtoUpdated.getCategory()).isEqualTo(produtoToBeSaved.getCategory());
        Assertions.assertThat(produtoUpdated.getSupplier()).isEqualTo(produtoToBeSaved.getSupplier());
        Assertions.assertThat(produtoUpdated.getCreatedIn()).isEqualTo(produtoToBeSaved.getCreatedIn());

    }

    @Test
    void delete_RemovesProduto(){
        Product produtoToBeSaved = createProduto();
        Product produtoSaved = produtoRepository.save(produtoToBeSaved);

        this.produtoRepository.delete(produtoSaved);

        Optional<Product> produtoOptional = this.produtoRepository.findById(produtoSaved.getId());

        Assertions.assertThat(produtoOptional).isEmpty();

    }

    @Test
    void findAll_ReturnListOfProdutos(){

        Product produtoToBeSaved = createProduto();
        Product produtoSaved = produtoRepository.save(produtoToBeSaved);

        List<Product> produtoList = produtoRepository.findAll();

        Assertions.assertThat(produtoList).isNotEmpty();

        Assertions.assertThat(produtoList).contains(produtoSaved);

    }

    @Test
    void findById_ReturnNotFound(){
        Product produtoToBeSaved = createProduto();

        Optional<Product> produtoOptional = produtoRepository.findById(0L);

        Assertions.assertThat(produtoOptional).isEmpty();


    }
    private Product createProduto(){
        return Product.builder()
                .name("Celular")
                .price(150.00)
                .stock(2)
                .createdIn(LocalDateTime.now())
                .description("Lorem")
                .supplier("Sicrano")
                .category("Eletronico")
                .build();
    }

}