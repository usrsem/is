package com.univer.informationsecurity.services.lab1;

import com.univer.informationsecurity.web.model.PasswordDto;
import com.univer.informationsecurity.web.model.PasswordInputData;
import com.univer.informationsecurity.web.model.SimplePasswordDto;
import com.univer.informationsecurity.web.model.SimplePasswordInputData;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class SimplePasswordGeneratorService implements PasswordGeneratorService {

    private static final String russianLetters = "йцукенгшщзхъфывапролджэёячсмитьбю";
    private static final int russianLettersLength = russianLetters.length();

    @Override
    public PasswordDto<SimplePasswordDto> generate(PasswordInputData<?> input) {
        StringBuilder stringBuilder = new StringBuilder();
        Random ran = new Random();

        // Generate first 2 random ints
        stringBuilder.append(ran.nextInt(10)).append(ran.nextInt(10));

        // Calculate Q
        int Q = ((SimplePasswordInputData) input).getIdentificator().length() % 8;

        // Generate rundom letters from russianLetters
        for (int i = 0; i <= Q; ++i) {
            stringBuilder.append(russianLetters.charAt(ran.nextInt(russianLettersLength - 1))); 
        }

        // Generate chars from 33 to 42 (!, ”, #, $, %, &, ’, (, ), *)
        for(int i = 4 + Q; i <= 11; ++i) {
            stringBuilder.append((char) (ran.nextInt(10) + 33));
        }
        
        return SimplePasswordDto.builder()
            .password(stringBuilder.toString())
            .Q(Q)
            .build();
    }

}
