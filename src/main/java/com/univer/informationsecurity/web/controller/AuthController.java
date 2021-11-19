package com.univer.informationsecurity.web.controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.univer.informationsecurity.services.lab2.AuthService;
import com.univer.informationsecurity.domain.Customer;

import com.univer.informationsecurity.exception.AuthException;

@CrossOrigin()
@RequestMapping("/api/v1/auth")
@RestController
public class AuthController {
   
    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws AuthException{
        return new ResponseEntity<>(authService.register(customer), HttpStatus.OK);
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) throws AuthException{
        return new ResponseEntity<>(authService.login(customer), HttpStatus.OK);
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<Customer> updatePassword(@RequestBody Customer customer) throws AuthException{
        return new ResponseEntity<>(authService.updatePassword(customer), HttpStatus.OK);
    }
}
