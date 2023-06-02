package com.springboot.crud.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private String fornecedor;

    @Column(nullable = false)
    private LocalDateTime criadoEm;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private int quantidade;

}
