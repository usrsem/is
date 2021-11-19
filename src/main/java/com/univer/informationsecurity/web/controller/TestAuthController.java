package com.univer.informationsecurity.web.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.univer.informationsecurity.services.lab2.AuthChecker;

import com.univer.informationsecurity.domain.BaseEntity;
import com.univer.informationsecurity.exception.AuthException;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/testAuth")
@RestController
public class TestAuthController {
   
    @Autowired
    AuthChecker authChecker;

    @GetMapping
    public ResponseEntity<String> registerCustomer(@RequestBody BaseEntity customerId) throws AuthException{
        System.out.println(customerId);
        if (customerId != null) {
            if (authChecker.check(customerId.getId())) {
                return new ResponseEntity<>("Secret info", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Hidden info", HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }
}
