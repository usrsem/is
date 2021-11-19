package com.univer.informationsecurity.domain;

import javax.persistence.Entity;

import lombok.*;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseEntity {

    private String username;
    private String password;

    private String lastName;
    private String firstName;
    private String middleName;

    private String dateOfBirth;
    private String placeOfBirth;

    private String phoneNumber;
}
