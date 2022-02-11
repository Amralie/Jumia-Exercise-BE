package com.jumia.exercise.controller;

import com.jumia.exercise.model.PhoneNumber;
import com.jumia.exercise.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @GetMapping("/phone-numbers")
    public List<PhoneNumber> getValidatedPhoneNumbers() {
        return phoneNumberService.getValidatedPhoneNumbers();
    }
}
