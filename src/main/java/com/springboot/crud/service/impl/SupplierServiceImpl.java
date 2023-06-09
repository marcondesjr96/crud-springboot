package com.springboot.crud.service.impl;

import com.springboot.crud.convert.ProductConvert;
import com.springboot.crud.convert.SupplierConvert;
import com.springboot.crud.domain.Supplier;
import com.springboot.crud.dto.request.product.ProductNewRequestDto;
import com.springboot.crud.dto.request.product.ProductNoSupplierNewRequestDto;
import com.springboot.crud.dto.request.supplier.SupplierNewRequestDto;
import com.springboot.crud.dto.response.supplier.SupplierResponseDto;
import com.springboot.crud.exceptions.BadRequestException;
import com.springboot.crud.repository.SupplierRepository;
import com.springboot.crud.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ProductServiceImpl productService;


    @Override
    public SupplierResponseDto retrieveSupplier(Long id) {
        Supplier supplier = supplierRepository.findById(id).orElseThrow(BadRequestException::new);
        return SupplierConvert.supplierToResponseDto(supplier);

    }

    @Override
    @Transactional
    public SupplierResponseDto createSupplier(SupplierNewRequestDto supplierRequestDto) {
        List<ProductNoSupplierNewRequestDto> productList = supplierRequestDto.getProductList();
        Supplier supplier = supplierRepository.save(SupplierConvert.supplierDtoToEntity(supplierRequestDto));
        productService.createListProduct(productList, supplier);
        return SupplierConvert.supplierToResponseDto(supplier);

    }
}
