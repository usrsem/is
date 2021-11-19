package com.univer.informationsecurity.web.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
/**
 * @param mods set of symbols for passwor
 * avaliable: latinUppercaseLetters, latinLowercaseLetters
 * russianUppercaseLetters russianLowercaseLetters,
 * numbers and symbols
 */
public class ImprovedPasswordInputData implements PasswordInputData<ImprovedPasswordInputData> {

    private double probability;

    private int velocity;

    private int time;

    private Set<String> mods;
}
