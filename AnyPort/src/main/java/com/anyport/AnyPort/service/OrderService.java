package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.dto.PlaceOrderDTO;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;

import java.util.List;

public interface OrderService {

    public Orders createOrder(PlaceOrderDTO placeOrderDTO, Integer id);
    public List<ActiveOrders> getAllActiveOrders();


}
