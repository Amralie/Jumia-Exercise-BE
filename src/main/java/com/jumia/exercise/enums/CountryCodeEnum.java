package com.jumia.exercise.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CountryCodeEnum {
    CAMEROON("237","Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$"),
    ETHIOPIA("251", "Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$"),
    MOROCCO("212", "Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$"),
    MOZAMBIQUE("258","Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$"),
    UGANDA("256","Uganda", "\\(256\\)\\ ?\\d{9}$");

    final String code;
    final String name;
    final String expression;

    public static CountryCodeEnum getValueByCode(String code) {
        for (CountryCodeEnum countryCode : CountryCodeEnum.values()) {
            if (countryCode.code.equalsIgnoreCase(code)) {
                return countryCode;
            }
        }
        return null;
    }
}
