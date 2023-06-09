package com.springboot.crud.repository;

import com.springboot.crud.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Supplier findByCnpj(String cnpj);
}
