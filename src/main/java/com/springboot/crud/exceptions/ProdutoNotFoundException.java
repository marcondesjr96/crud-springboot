package com.springboot.crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProdutoNotFoundException extends ResponseStatusException {


    public ProdutoNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Produto não encontrado");
    }
}
