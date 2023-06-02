package com.springboot.crud.service;

import com.springboot.crud.dto.ProdutoDTO;
import com.springboot.crud.dto.ProdutoFormDTO;

import java.util.List;

public interface ProdutoService {

    ProdutoDTO buscarProduto (Long codigo);

    List<ProdutoDTO> listarProdutos ();

    ProdutoDTO criarProduto (ProdutoFormDTO produtoFormDTO);

    ProdutoDTO atualizarProduto(Long codigo, ProdutoFormDTO produtoFormDTO) throws Exception;

    void deletarProduto(Long codigo) throws Exception;

}
