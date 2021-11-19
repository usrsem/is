package com.univer.informationsecurity.services.lab2.confirmer;

import org.springframework.stereotype.Service;
import java.util.regex.*;

@Service("password")
public class CustomerPasswordConfirmer implements BasicConfirmer {

    // Only cyrillic words with length 11 
    private static final Pattern pattern = Pattern.compile("[йцукенгшщзхъёэждлорпавыфячсмитьбю]{11,}");

    @Override
    public boolean confirm(Object value) {
        return pattern.matcher(value.toString()).find();
    }
}
