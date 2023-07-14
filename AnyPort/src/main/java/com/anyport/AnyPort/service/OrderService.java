package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.models.Orders;

public interface OrderService {

    public Orders createOrder(Orders orders,Integer id);


}
