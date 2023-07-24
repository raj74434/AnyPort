package com.anyport.AnyPort.models;

import lombok.Data;

import javax.persistence.Entity;

import javax.persistence.Id;

@Data
@Entity
public class ActiveOrders {

    @Id
    private Integer orderId;

    private Integer price;
    private String payment_method;
    private String pickupAddress;
    private String dropAddress;
    private String status;


}
