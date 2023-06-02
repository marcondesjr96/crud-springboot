package com.springboot.crud.service;

import com.springboot.crud.convert.ProductConvert;
import com.springboot.crud.domain.Product;
import com.springboot.crud.dto.ProductResponseDto;
import com.springboot.crud.dto.ProductRequestDto;
import com.springboot.crud.exceptions.BadRequestException;
import com.springboot.crud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public final ProductRepository productRepository;


    @Override
    public ProductResponseDto retrieveProduct(Long code){
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        return ProductConvert.produtoDomainToDto(product);
    }

    @Override
    public List<ProductResponseDto> listProducts() {
        List<Product> productList = productRepository.findAll();
        if(productList.isEmpty()){
            throw new BadRequestException();
        }
        List<ProductResponseDto> dtoList = new ArrayList<>();
        for(Product product : productList){
            ProductResponseDto productResponseDto = ProductConvert.produtoDomainToDto(product);
            dtoList.add(productResponseDto);
        }
        return dtoList;
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = ProductConvert.produtoDtoToDomain(productRequestDto);
        productRepository.save(product);
        return ProductConvert.produtoDomainToDto(product);

    }

    @Override
    public ProductResponseDto updateProduct(Long code, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        setValues(product, productRequestDto);
        productRepository.save(product);
        return ProductConvert.produtoDomainToDto(product);
    }

    private void setValues(Product entity, ProductRequestDto dto){

        entity.setName(dto.getName() == null ? entity.getName() : dto.getName());
        entity.setStock(dto.getStock() < 0  ? entity.getStock() : dto.getStock());
        entity.setPrice(dto.getPrice() < 0 ? entity.getPrice() : dto.getPrice());
        entity.setCategory(dto.getCategory() == null ? entity.getCategory() : dto.getCategory());
        entity.setDescription(dto.getDescription() == null ? entity.getDescription() : dto.getDescription());
        entity.setSupplier(dto.getSupplier() == null ? entity.getSupplier() : dto.getSupplier());

    }

    @Override
    public void deleteProduct(Long code){
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        productRepository.delete(product);

    }
}
