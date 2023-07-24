package com.anyport.AnyPort.mappingInfo;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MappingInfo {

    @Autowired
    private ModelMapper modelMapper;

    public User userDto_to_user(UserDto dto){
        return modelMapper.map(dto, User.class);
    }

    public UserDto user_to_userDto(User user){
        return modelMapper.map(user, UserDto.class);
    }


    public Orders dto_To_Orders(OrderDto orderDto){
        return modelMapper.map(orderDto,Orders.class);
    }
    public OrderDto orders_To_Dto(Orders orders){
        return modelMapper.map(orders,OrderDto.class);
    }

    public ActiveOrders orders_To_ActiveOrders(Orders orders){
        return modelMapper.map(orders,ActiveOrders.class);
    }

}
