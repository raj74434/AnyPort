package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;

import java.util.List;

public interface UserService {

    public User createCustomerUser(UserDto userDto);
    public List<Orders> oldOrders(Integer id);

}
