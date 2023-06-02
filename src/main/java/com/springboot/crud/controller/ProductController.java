package com.springboot.crud.controller;

import com.springboot.crud.dto.ProductResponseDto;
import com.springboot.crud.dto.ProductRequestDto;
import com.springboot.crud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
@RequiredArgsConstructor

public class ProductController {

    public final ProductService productService;
    @GetMapping("/{id}")
    public ProductResponseDto retrieveProduct(@PathVariable("id") Long code) {
        return productService.retrieveProduct(code);
    }
    @GetMapping("/product")
    public List<ProductResponseDto> listProducts(){
        return productService.listProducts();
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }
    @PutMapping("/{id}")
    public ProductResponseDto updateProduct(@PathVariable("id") Long code, @RequestBody ProductRequestDto productRequestDto) throws Exception {
        return productService.updateProduct(code, productRequestDto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") Long code) throws Exception {
        productService.deleteProduct(code);
    }


}
