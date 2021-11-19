package com.univer.informationsecurity.services.lab2;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.univer.informationsecurity.repository.AuthRepository;

import java.util.UUID;

@Service
public class AuthCheckerImpl implements AuthChecker {

    @Autowired
    AuthRepository repository;

    @Override
    public boolean check(UUID id) {
        return repository.findById(id).isPresent();
    }
}
