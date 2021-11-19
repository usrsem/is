package com.univer.informationsecurity.web.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImprovedPasswordDto implements PasswordDto<ImprovedPasswordDto> {

    private BigInteger minimalAlphabetPower;

    private int alphabetPower;

    private int passwordLength;

    private String password;
}
