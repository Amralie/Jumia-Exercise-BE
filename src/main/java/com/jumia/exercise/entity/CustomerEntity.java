package com.jumia.exercise.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Data
public class CustomerEntity {
    @Id
    private int id;
    private String name;
    private String phone;
}
