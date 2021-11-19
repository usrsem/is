package com.univer.informationsecurity.web.controller;

import org.springframework.web.bind.annotation.*;
import com.univer.informationsecurity.web.model.PasswordDto;
import com.univer.informationsecurity.web.model.SimplePasswordInputData;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.univer.informationsecurity.services.lab1.PasswordGeneratorService;

@CrossOrigin()
@RequestMapping("/api/v1/password")
@RestController
@Slf4j
public class SimplePasswordGeneratorController {
    
    @Autowired
    PasswordGeneratorService simplePasswordGeneratorService;

    @GetMapping("/generate")
    public ResponseEntity<PasswordDto<?>> getPassword(@RequestParam(value = "identificator") SimplePasswordInputData identificator) {
        log.info("Password requested");
        return new ResponseEntity<>(simplePasswordGeneratorService.generate(identificator), HttpStatus.OK);
    }
}
