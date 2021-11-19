package com.univer.informationsecurity.services.lab2;

import com.univer.informationsecurity.repository.AuthRepository;
import com.univer.informationsecurity.domain.Customer;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.univer.informationsecurity.exception.AuthException;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    AuthRepository repository;

    @Autowired
    CustomerVerificator verificator;
   
    @Override
    public Customer register(Customer newCustomer) throws AuthException {
        verificator.verify(newCustomer);
        // Check if username already exists
        Optional<Customer> customerOptional = repository.findByUsername(newCustomer.getUsername());
        if (customerOptional.isPresent()) {
            if (newCustomer.getUsername().equals(customerOptional.get().getUsername())) {
                throw new AuthException("User with this username already exists");
            }
        }
        // Save new customer
        repository.save(newCustomer);
        return newCustomer;
    }
    
    @Override
    public Customer login(Customer customer) throws AuthException{
        verificator.verify(customer);
        // Get customer and check password
        Optional<Customer> customerOptional = repository.findByUsername(customer.getUsername());
        if (customerOptional.isPresent()) {
            if (customer.getPassword().equals(customerOptional.get().getPassword())) {
                return customerOptional.get();
            }
        }
        throw new AuthException("Incorrect password or username");
        
    }

    @Override
    public Customer updatePassword(Customer customer) throws AuthException {
        verificator.verify(customer);
        Optional<Customer> customerOptional = repository.findById(customer.getId());
        if (customerOptional.isPresent()) {
            if (customer.getPassword().equals(customerOptional.get().getPassword())) {
                throw new AuthException("Old and new passwords must be different");
            } else if (customer.getPassword().equals(customerOptional.get().getLastName())) {
                throw new AuthException("Password can't be same with your last name");
            } else {
                Customer newCustomer = customerOptional.get();
                newCustomer.setPassword(customer.getPassword());
                repository.save(newCustomer);
                return newCustomer;
            }
        }
        throw new AuthException("There is not user with this id");
    }
}
