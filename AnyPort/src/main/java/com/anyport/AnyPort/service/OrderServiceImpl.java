package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.mappingInfo.MappingInfo;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.ActiveOrderRepo;
import com.anyport.AnyPort.repository.OrdersRepo;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private MappingInfo mapper;

    @Autowired
    private ActiveOrderRepo activeOrderRepo;

    @Override
    public Orders createOrder(Orders orders,Integer id){
        Optional<User> user=userRepo.findById(id);
        User response=user.get();
        if(response!=null) {
            orders.setStatus("Active");
            orders.setOrderPlacedTime(LocalDateTime.now());
            response.addOrder(orders);
            ActiveOrders activeOrders = mapper.orders_To_ActiveOrders(orders);
             userRepo.save(response);
             return orders;
        }
        else{
            return null;
        }
    }




}
