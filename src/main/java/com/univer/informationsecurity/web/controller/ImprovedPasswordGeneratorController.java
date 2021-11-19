package com.univer.informationsecurity.web.controller;

import org.springframework.web.bind.annotation.*;

import com.univer.informationsecurity.web.model.ImprovedPasswordInputData;
import com.univer.informationsecurity.web.model.PasswordDto;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import com.univer.informationsecurity.services.lab1.PasswordGeneratorService;

@CrossOrigin()
@RequestMapping("/api/v1/improvedPassword")
@RestController
@Slf4j
public class ImprovedPasswordGeneratorController {
    
    @Autowired
    PasswordGeneratorService improvedPasswordGeneratorService;

    @PostMapping("/generate")
    public ResponseEntity<PasswordDto<?>> getPassword(@RequestBody ImprovedPasswordInputData identificator) {
        log.info("Improved password requested");
        log.info(improvedPasswordGeneratorService.getClass().toString());
        return new ResponseEntity<>(improvedPasswordGeneratorService.generate(identificator), HttpStatus.OK);
    }
}
