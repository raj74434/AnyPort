package com.anyport.AnyPort.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String home;

    private String area;
    private String pincode;

    private String phone;

    private Double longitude;

    private Double latitude;
}
