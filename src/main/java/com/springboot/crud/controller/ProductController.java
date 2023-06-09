package com.springboot.crud.controller;

import com.springboot.crud.dto.response.product.ProductResponseDto;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/product")
@CrossOrigin
@RequiredArgsConstructor
@RestController
public class ProductController {

    public final ProductService productService;
    @GetMapping("/{id}")
    public ProductResponseDto retrieveProduct(@PathVariable("id") Long code) {
        return productService.retrieveProduct(code);
    }
    @GetMapping("/all")
    public List<ProductResponseDto> listProducts(){
        return productService.listProducts();
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
