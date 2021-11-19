package com.univer.informationsecurity.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SimplePasswordInputData implements PasswordInputData<SimplePasswordInputData> {
    private String identificator;
}
