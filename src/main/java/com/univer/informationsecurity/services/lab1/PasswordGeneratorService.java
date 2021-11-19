package com.univer.informationsecurity.services.lab1;

import com.univer.informationsecurity.web.model.PasswordDto;
import com.univer.informationsecurity.web.model.PasswordInputData;

public interface PasswordGeneratorService {

    PasswordDto<?> generate(PasswordInputData<?> input);

}
