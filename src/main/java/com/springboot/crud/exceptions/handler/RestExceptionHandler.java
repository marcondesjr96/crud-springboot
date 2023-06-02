package com.springboot.crud.exceptions.handler;

import com.springboot.crud.exceptions.BadRequestException;
import com.springboot.crud.exceptions.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<BadRequestExceptionDetails> handlerNotFoundException(BadRequestException ex){
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(ex.getStatus().value())
                .title("Bad Request Exception, Check the Documantion")
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }

}
