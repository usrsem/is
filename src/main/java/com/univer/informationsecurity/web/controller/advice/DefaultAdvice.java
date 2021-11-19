package com.univer.informationsecurity.web.controller.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import com.univer.informationsecurity.exception.AuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<String> handleResponse(AuthException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
    }

}
