package com.univer.informationsecurity.services.lab2;

import com.univer.informationsecurity.domain.Customer;
import com.univer.informationsecurity.exception.AuthException;

public interface AuthService {
   
    /**
     * Serivce for registrating [Customer] in db
     *
     * @param newCustomer model with customer data
     */
    Customer register(Customer newCustomer) throws AuthException;
    Customer login(Customer customer) throws AuthException;
    Customer updatePassword(Customer customer) throws AuthException;
}
