package com.springboot.crud.service.impl;

import com.springboot.crud.convert.ProductConvert;
import com.springboot.crud.domain.Product;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.response.PageDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.response.product.ProductTableResponseDto;
import com.springboot.crud.exceptions.BadRequestException;
import com.springboot.crud.repository.ProductRepository;
import com.springboot.crud.repository.SupplierRepository;
import com.springboot.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;


    @Override
    public ProductResponseDto retrieveProduct(Long code) {
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        return ProductConvert.produtoDomainToDto(product);
    }

    @Override
    public ProductTableResponseDto getProductTableById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(BadRequestException::new);
        return ProductConvert.toProductTableDto(product);
    }

    @Override
    public PageDto<ProductResponseDto> listProducts(Pageable pageable) {
        PageRequest pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("price"));

        final Page<Product> clientePage = productRepository.findAll(pageRequest);
        return ProductConvert.toPageProductResponseDto(clientePage);
    }

    @Override
    @Transactional
    public ProductResponseDto createProduct(ProductNewRequestDto productRequestDto) {
        Product product = ProductConvert.produtoDtoToDomain(productRequestDto);
        setSupplier(productRequestDto, product);
        productRepository.save(product);
        return ProductConvert.produtoDomainToDto(product);
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

    @Override
    public void deleteProduct(Long code) {
        Product product = productRepository.findById(code).orElseThrow(BadRequestException::new);
        productRepository.delete(product);

    }

    private void setSupplier(ProductNewRequestDto productRequestDto, Product product) {
        Supplier supplier = supplierRepository.findByCnpj(productRequestDto.getSupplier().getCnpj());
        if (ObjectUtils.isEmpty(supplier)) {
            supplierRepository.save(product.getSupplier());
        } else {
            product.getSupplier().setId(supplier.getId());
        }
    }

    private void setValues(Product entity, ProductNewRequestDto dto) {

        entity.setName(dto.getName() == null ? entity.getName() : dto.getName());
        entity.setStock(dto.getStock() < 0 ? entity.getStock() : dto.getStock());
        entity.setPrice(dto.getPrice() < 0 ? entity.getPrice() : dto.getPrice());
        entity.setCategory(dto.getCategory() == null ? entity.getCategory() : dto.getCategory());
        entity.setDescription(dto.getDescription() == null ? entity.getDescription() : dto.getDescription());


    }
}
