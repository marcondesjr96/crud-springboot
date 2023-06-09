package com.springboot.crud.service.impl;

import com.springboot.crud.convert.ProductConvert;
import com.springboot.crud.convert.SupplierConvert;
import com.springboot.crud.domain.Product;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNoListProductNewRequestDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.exceptions.BadRequestException;
import com.springboot.crud.repository.ProductRepository;
import com.springboot.crud.repository.SupplierRepository;
import com.springboot.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    public final ProductRepository productRepository;
    public final SupplierRepository supplierRepository;


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
            dtoList.add(ProductConvert.produtoDomainToDto(product));
        }
        return dtoList;
    }

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductNewRequestDto productRequestDto) {
        Product product = ProductConvert.produtoDtoToDomain(productRequestDto);
        setSupplier(productRequestDto, product);
        productRepository.save(product);
        return ProductConvert.produtoDomainToDto(product);
    }

    private void setSupplier(ProductNewRequestDto productRequestDto, Product product) {
        Supplier supplier = supplierRepository.findByCnpj(productRequestDto.getSupplier().getCnpj());
        if(ObjectUtils.isEmpty(supplier)){
            supplierRepository.save(product.getSupplier());
        }else{
            product.getSupplier().setId(supplier.getId());
        }
    }

    @Override
    @Transactional
    public void createListProduct(List<ProductNoSupplierNewRequestDto> products, Supplier supplier) {
        List<Product> productList = new ArrayList<>();

        for (ProductNoSupplierNewRequestDto product : products) {
            Product productEntity = ProductConvert.produtoNoSupplierDtoToDomain(product);
            productList.add(productEntity);
        }
        productRepository.saveAll(productList);
    }

    @Override
    public ProductResponseDto updateProduct(Long code, ProductNewRequestDto productRequestDto) {
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        setValues(product, productRequestDto);
        productRepository.save(product);
        return ProductConvert.produtoDomainToDto(product);
    }

    private void setValues(Product entity, ProductNewRequestDto dto){

        entity.setName(dto.getName() == null ? entity.getName() : dto.getName());
        entity.setStock(dto.getStock() < 0  ? entity.getStock() : dto.getStock());
        entity.setPrice(dto.getPrice() < 0 ? entity.getPrice() : dto.getPrice());
        entity.setCategory(dto.getCategory() == null ? entity.getCategory() : dto.getCategory());
        entity.setDescription(dto.getDescription() == null ? entity.getDescription() : dto.getDescription());


    }

    @Override
    public void deleteProduct(Long code){
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        productRepository.delete(product);

    }
}
