package com.springboot.crud.controller;

import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.response.PageDto;
import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;
    @GetMapping("/{id}")
    public ProductResponseDto retrieveProduct(@PathVariable("id") Long code) {
        return productService.retrieveProduct(code);
    }
    @GetMapping("/all")
    public PageDto<ProductResponseDto> listProducts(Pageable pageable){
        return productService.listProducts(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody ProductNewRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }
    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable("id") Long code, @RequestBody ProductNewRequestDto productRequestDto) throws Exception {
        return productService.updateProduct(code, productRequestDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long code) throws Exception {
        productService.deleteProduct(code);
    }


}
