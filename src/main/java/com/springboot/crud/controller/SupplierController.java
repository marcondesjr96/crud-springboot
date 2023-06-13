package com.springboot.crud.controller;

import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierUpdateResquestDto;
import com.springboot.crud.dto.response.supplier.SupplierResponseDto;
import com.springboot.crud.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/supplier")
@RequiredArgsConstructor
@CrossOrigin
@RestController
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping("/{id}")
    public SupplierResponseDto retrieveSupplier(@PathVariable("id") Long id){
        return supplierService.retrieveSupplier(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SupplierResponseDto createSupplier(@RequestBody SupplierNewRequestDto supplierRequestDto){
        return supplierService.createSupplier(supplierRequestDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplierResponseDto updateSupplier(@PathVariable("id") Long id, @RequestBody SupplierUpdateResquestDto dto){
        return supplierService.updateSupplier(id, dto);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSupplierById(@PathVariable("id") Long id){
        supplierService.deleteSupplierById(id);
    }


}
