package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.mappingInfo.MappingInfo;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.repository.ActiveOrderRepo;
import com.anyport.AnyPort.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private MappingInfo mapper;

    @Autowired
    private ActiveOrderRepo activeOrderRepo;

    public Orders createOrder(OrderDto orderDto){
        orderDto.setStatus("Active");
        Orders orders=mapper.dto_To_Orders(orderDto);
        Orders final_order=ordersRepo.save(orders);
        ActiveOrders activeOrders=mapper.orders_To_ActiveOrders(final_order);

       return final_order;
    }




}
