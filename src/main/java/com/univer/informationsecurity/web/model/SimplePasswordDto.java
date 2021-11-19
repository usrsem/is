package com.univer.informationsecurity.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SimplePasswordDto implements PasswordDto<SimplePasswordDto> {
    private String password;
    private int Q;

}
