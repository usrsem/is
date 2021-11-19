package com.univer.informationsecurity.services.lab2;

import com.univer.informationsecurity.domain.Customer;
import com.univer.informationsecurity.exception.AuthException;

public interface CustomerVerificator {
    void verify(Customer customer) throws AuthException;
}
