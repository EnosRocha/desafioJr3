package com.example.desafioOs.Exceptions;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ClientAlreadyExistException.class)
    public ResponseEntity clientAlreadyExistExceptioHandler(ClientAlreadyExistException
                                                                    clientAlreadyExistException) {

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity orderNotFoundExceptionHandler(OrderNotFoundException orderNotFoundException) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND
        );
    }
}
