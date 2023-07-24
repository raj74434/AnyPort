package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Background;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;

import java.util.List;

public interface DriverService   {

    User createDriverUser(UserDto userDto);


    Background veryfyBackground(Background background, Integer userId);

    public List<Orders> catchOrder(Integer orderId, Integer userId);

    public List<ActiveOrders> getAllActiveOrders();

}
