package com.jumia.exercise.model;

import lombok.Data;

@Data
public class PhoneNumber {
    private String country;
    private String state;
    private String code;
    private String number;
}
