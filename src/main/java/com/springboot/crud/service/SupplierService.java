package com.springboot.crud.service;

import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierUpdateResquestDto;
import com.springboot.crud.dto.response.supplier.SupplierResponseDto;

public interface SupplierService {

    SupplierResponseDto retrieveSupplier (Long id);

    SupplierResponseDto createSupplier(SupplierNewRequestDto supplierRequestDto);

    SupplierResponseDto updateSupplier(Long id, SupplierUpdateResquestDto supplierUpdateResquestDto);


}
