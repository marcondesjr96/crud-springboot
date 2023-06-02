package com.springboot.crud.controller;

import com.springboot.crud.dto.ProdutoDTO;
import com.springboot.crud.dto.ProdutoFormDTO;
import com.springboot.crud.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor

public class ProdutoController {

    public final ProdutoService produtoService;
    @GetMapping("/{id}")
    public ProdutoDTO buscarProduto(@PathVariable("id") Long codigo) {
        return produtoService.buscarProduto(codigo);
    }
    @GetMapping("/produtos")
    public List<ProdutoDTO> listarProdutos(){
        return produtoService.listarProdutos();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO adicionarProduto(@RequestBody ProdutoFormDTO produtoFormDTO){
        return produtoService.criarProduto(produtoFormDTO);
    }
    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto(@PathVariable("id") Long codigo, @RequestBody ProdutoFormDTO produtoFormDTO) throws Exception {
        return produtoService.atualizarProduto(codigo, produtoFormDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable("id") Long codigo) throws Exception {
        produtoService.deletarProduto(codigo);
    }


}
