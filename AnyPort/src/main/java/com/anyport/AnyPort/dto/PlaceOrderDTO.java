package com.anyport.AnyPort.dto;

import com.anyport.AnyPort.models.Address;
import lombok.Data;

@Data
public class PlaceOrderDTO {


    private Address sender;
    private Address reciver;
    private String payment_method;
    private String payment_by;



}
