package com.springboot.crud.service;

import com.springboot.crud.convert.ProdutoConvert;
import com.springboot.crud.domain.Produto;
import com.springboot.crud.dto.ProdutoDTO;
import com.springboot.crud.dto.ProdutoFormDTO;
import com.springboot.crud.exceptions.ProdutoNotFoundException;
import com.springboot.crud.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService{

    public final ProdutoRepository produtoRepository;


    @Override
    public ProdutoDTO buscarProduto(Long codigo) throws Exception {
        Produto produto = produtoRepository.findById(codigo).orElseThrow(() -> new ProdutoNotFoundException());
        return ProdutoConvert.produtoDomainToDto(produto);
    }

    @Override
    public List<ProdutoDTO> listarProdutos() throws Exception {
        List<Produto> produtos = produtoRepository.findAll();
        if(produtos.isEmpty()){
            throw new ProdutoNotFoundException();
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
        Produto produto = produtoRepository.findById(codigo).orElseThrow(() -> new ProdutoNotFoundException());
        setValues(produto, produtoFormDTO);
        produtoRepository.save(produto);
        return ProdutoConvert.produtoDomainToDto(produto);
    }

    private void setValues(Produto entity, ProdutoFormDTO produtoDTO){
        entity.setNome(produtoDTO.getNome() == null ? entity.getNome() : produtoDTO.getNome());
        entity.setQuantidade(produtoDTO.getQuantidade() < 0  ? entity.getQuantidade() : produtoDTO.getQuantidade());
        entity.setValor(produtoDTO.getValor() < 0 ? entity.getValor() : produtoDTO.getValor());

    }

    @Override
    public void deletarProduto(Long codigo) throws Exception {
        Produto produto = produtoRepository.findById(codigo).orElseThrow(() -> new ProdutoNotFoundException());
        produtoRepository.delete(produto);

    }
}
