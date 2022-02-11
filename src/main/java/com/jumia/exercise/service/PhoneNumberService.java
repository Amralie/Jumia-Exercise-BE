package com.jumia.exercise.service;

import com.jumia.exercise.entity.CustomerEntity;
import com.jumia.exercise.enums.CountryCodeEnum;
import com.jumia.exercise.model.PhoneNumber;
import com.jumia.exercise.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PhoneNumberService {

    @Autowired
    CustomerRepository customerRepository;

    public List<PhoneNumber> getValidatedPhoneNumbers() {
        List<CustomerEntity> customers = customerRepository.findAll();
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        customers.forEach(customer -> phoneNumbers.add(createValidatedPhoneNumber(customer.getPhone())));
        return phoneNumbers;
    }

    private PhoneNumber createValidatedPhoneNumber(String phone) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber(getNumber(phone));
        phoneNumber.setCode("+" + getCode(phone));
        phoneNumber.setCountry(getCountry(phone));
        phoneNumber.setState(getState(phone));
        return phoneNumber;
    }

    private String getNumber(String phone) {
        return phone.substring(6);
    }

    private String getCode(String phone) {
        return phone.substring(1, 4);
    }

    private String getCountry(String phone) {
        switch (Objects.requireNonNull(CountryCodeEnum.getValueByCode(getCode(phone)))) {
            case CAMEROON: {
                return CountryCodeEnum.CAMEROON.getName();
            }
            case ETHIOPIA: {
                return CountryCodeEnum.ETHIOPIA.getName();
            }
            case MOROCCO: {
                return CountryCodeEnum.MOROCCO.getName();
            }
            case MOZAMBIQUE: {
                return CountryCodeEnum.MOZAMBIQUE.getName();
            }
            case UGANDA: {
                return CountryCodeEnum.UGANDA.getName();
            }
            default: {
                return null;
            }
        }
    }

    private String getState(String phone) {
        switch (Objects.requireNonNull(CountryCodeEnum.getValueByCode(getCode(phone)))) {
            case CAMEROON: {
                return validate(phone, CountryCodeEnum.CAMEROON.getExpression());
            }
            case ETHIOPIA: {
                return validate(phone, CountryCodeEnum.ETHIOPIA.getExpression());
            }
            case MOROCCO: {
                return validate(phone, CountryCodeEnum.MOROCCO.getExpression());
            }
            case MOZAMBIQUE: {
                return validate(phone, CountryCodeEnum.MOZAMBIQUE.getExpression());
            }
            case UGANDA: {
                return validate(phone, CountryCodeEnum.UGANDA.getExpression());
            }
            default: {
                return null;
            }
        }
    }

    private String validate(String phoneNumber, String expression) {
        boolean isValid = phoneNumber.matches(expression);
        return isValid ? "valid" : "not valid";
    }
}
