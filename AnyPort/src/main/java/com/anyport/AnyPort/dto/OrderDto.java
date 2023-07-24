package com.anyport.AnyPort.dto;

import com.anyport.AnyPort.models.User;
import lombok.Data;

import javax.persistence.OneToOne;

@Data
public class OrderDto {

    private Integer price;
    private Integer payment_method;
    private String sender;
    private String reciver;

    private String status;







}
