package com.univer.informationsecurity.services.lab2;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.univer.informationsecurity.domain.Customer;
import com.univer.informationsecurity.exception.AuthException;
import com.univer.informationsecurity.services.lab2.confirmer.BasicConfirmer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerVerificatorImpl implements CustomerVerificator {

    // TODO: test
    @Autowired
    private Map<String, BasicConfirmer> confirmers;

    @Override
    public void verify(Customer customer) throws AuthException {
        for (Entry<String, Object> entry : getMapOfCustomerFields(customer).entrySet()) {
            if (confirmers.containsKey(entry.getKey())) {
                if (!confirmers.get(entry.getKey()).confirm(entry.getValue())) {
                    throw new AuthException(
                            "Wrong data " + entry.getValue().toString() + " in field " + entry.getKey());
                }
            } else {
                log.warn("Cant find key for field: " + entry.getKey());
            }
        }

    }

    /**
     * Some test description
     * 
     * @param customer - test
     * 
     * @return - some test map
     */
    private Map<String, Object> getMapOfCustomerFields(Customer customer) {
        Map<String, Object> map = new HashMap<>();
        for (Field field : Customer.class.getDeclaredFields()) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                map.put(field.getName(), field.get(customer));
            } catch (Exception e) {
                log.error("Error while parsing field of Customer: " + field.getName() + " .Error: " + e.getMessage());
            }
        }
        log.info(map.toString());
        return map;
    }
}
