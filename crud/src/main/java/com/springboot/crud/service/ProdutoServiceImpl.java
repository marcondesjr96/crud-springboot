package com.springboot.crud.service;

import com.springboot.crud.convert.ProdutoConvert;
import com.springboot.crud.domain.Produto;
import com.springboot.crud.dto.ProdutoDTO;
import com.springboot.crud.dto.ProdutoFormDTO;
import com.springboot.crud.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProdutoServiceImpl implements ProdutoService{

    public final ProdutoRepository produtoRepository;


    @Override
    public ProdutoDTO buscarProduto(Long codigo) throws Exception {
        Optional<Produto> produtoOpt = produtoRepository.findById(codigo);
        if(!produtoOpt.isPresent()){
            throw new Exception("Produto não encontrado!");
        }

        return ProdutoConvert.produtoDomainToDto(produtoOpt.get());
    }

    @Override
    public List<ProdutoDTO> listarProdutos() throws Exception {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            throw new Exception("Nenhum produto encontrado");
        }
        List<ProdutoDTO> produtoDTOList = new ArrayList<>();
        for(Produto produto : produtos){
            ProdutoDTO produtoDTO = ProdutoConvert.produtoDomainToDto(produto);
            produtoDTOList.add(produtoDTO);

        }
        return produtoDTOList;
    }

    @Override
    public ProdutoDTO criarProduto(ProdutoFormDTO produtoFormDTO) {
        Produto produto = ProdutoConvert.produtoDtoToDomain(produtoFormDTO);
        produtoRepository.save(produto);

        return ProdutoConvert.produtoDomainToDto(produto);

    }

    @Override
    public ProdutoDTO atualizarProduto(Long codigo, ProdutoFormDTO produtoFormDTO) throws Exception {
        Optional<Produto> produtoOpt = produtoRepository.findById(codigo);
        if(!produtoOpt.isPresent()){
            throw new Exception("Produto não encontrado");
        }
        Produto entity = produtoOpt.get();
        entity.setNome(produtoFormDTO.getNome());
        entity.setQuantidade(produtoFormDTO.getQuantidade());
        entity.setValor(produtoFormDTO.getValor());
        produtoRepository.save(entity);
        return ProdutoConvert.produtoDomainToDto(entity);
    }

    @Override
    public void deletarProduto(Long codigo) throws Exception {
        Optional<Produto> produtoOpt = produtoRepository.findById(codigo);
        if (!produtoOpt.isPresent()) {
            throw new Exception("Agendamento não encontrado");
        }
        produtoRepository.delete(produtoOpt.get());

    }
}
