package com.springboot.crud.service.impl;

import com.springboot.crud.convert.SupplierConvert;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.response.supplier.SupplierResponseDto;
import com.springboot.crud.exceptions.BadRequestException;
import com.springboot.crud.repository.SupplierRepository;
import com.springboot.crud.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ModelMapper modelMapper;



    @Override
    public SupplierResponseDto retrieveSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(BadRequestException::new);
        return SupplierConvert.supplierToResponseDto(supplier);

    }

    @Override
    @Transactional
    @CacheEvict(value = "suppliers", allEntries = true)
    public SupplierResponseDto createSupplier(SupplierNewRequestDto supplierRequestDto) {
        Supplier supplier = modelMapper.map(supplierRequestDto, Supplier.class);
        supplier.getProductList().stream().forEach(product -> product.setSupplier(supplier));
        supplierRepository.save(supplier);
        return SupplierConvert.supplierToResponseDto(supplier);

    }
}
