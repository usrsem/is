package com.univer.informationsecurity.services.lab3;

import com.univer.informationsecurity.services.lab1.PasswordGeneratorService;
import com.univer.informationsecurity.web.model.PasswordDto;
import com.univer.informationsecurity.web.model.PasswordInputData;

import org.springframework.stereotype.Service;

import com.univer.informationsecurity.web.model.ImprovedPasswordInputData;
import com.univer.informationsecurity.web.model.ImprovedPasswordDto;
import java.util.Map;
import java.util.Random;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.stream.*;

@Service
public class ImprovedPasswordGeneratorService implements PasswordGeneratorService {

    public static final Map<String, String> mods = new HashMap<>();

    static { 
        mods.put("russianLowercaseLetters", "йцукенгшщзхъфывапролджэёячсмитьбю");
        mods.put("russianUppercaseLetters", mods.get("russianLowercaseLetters").toUpperCase());
        mods.put("latinLowercaseLetters", getStringOfAsciiCharsInRange(97, 122));
        mods.put("latinUppercaseLetters", mods.get("latinLowercaseLetters").toUpperCase());
        mods.put("numbers", getStringOfAsciiCharsInRange(48, 57));
        mods.put("symbols", new StringBuilder()
                .append(getStringOfAsciiCharsInRange(33, 47))
                .toString()
        );
    }

	@Override
	public PasswordDto<?> generate(PasswordInputData<?> input) {
        ImprovedPasswordInputData data = (ImprovedPasswordInputData) input;
        ImprovedPasswordDto res = new ImprovedPasswordDto();
        
        // Convert weeks to minutes
        int time = data.getTime() * 7 * 24 * 60;
        StringBuilder builder = new StringBuilder();
        Random ran = new Random();
        double a = Math.ceil(time * data.getVelocity() / data.getProbability());

        res.setMinimalAlphabetPower(BigDecimal.valueOf(a).toBigInteger());

        for(String mod : data.getMods()) {
            if (mods.containsKey(mod)) {
                builder.append(mods.get(mod));
            }
        }

        String allSymbols = builder.toString();
        res.setAlphabetPower(allSymbols.length());
        res.setPasswordLength(calculateLengthOfPassword(res.getAlphabetPower(), res.getMinimalAlphabetPower().doubleValue()));
        
        StringBuilder password = new StringBuilder();
        for(int i = 0; i < res.getPasswordLength(); ++i) {
            password.append(allSymbols.charAt(ran.nextInt(res.getAlphabetPower() - 1)));
        }

        res.setPassword(password.toString());

		return res;
	}

    private static String getStringOfAsciiCharsInRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .map(i -> Character.toChars(i))
                .collect(Collector.of(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append,
                        StringBuilder::toString
                        ));
    }

    private static int calculateLengthOfPassword(double power, double minimalCount) {
        return (int) Math.ceil(Math.log(minimalCount) / Math.log(power));
    }

}
