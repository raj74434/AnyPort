package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.dto.PlaceOrderDTO;
import com.anyport.AnyPort.mappingInfo.MappingInfo;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Address;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.ActiveOrderRepo;
import com.anyport.AnyPort.repository.OrdersRepo;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private Orders orders;

    @Autowired
    private MappingInfo mapper;

    @Autowired
    private ActiveOrderRepo activeOrderRepo;



    @Override
    public Orders createOrder(PlaceOrderDTO placeOrderDTO, Integer id){
        Optional<User> user=userRepo.findById(id);
        User response=user.get();
        if(response!=null && response.getUserType().equals("Customer")) {
            orders.setStatus("Active");
            orders.setOrderPlacedTime(LocalDateTime.now());
            orders.setPayment_method(placeOrderDTO.getPayment_method());
            orders.setPayment_by(placeOrderDTO.getPayment_by());
            orders.setPrice(1000);

            Address senderAddress=new Address();
            senderAddress.setArea(placeOrderDTO.getSender().getArea());
            senderAddress.setPhone(placeOrderDTO.getSender().getPhone());
            senderAddress.setHome(placeOrderDTO.getSender().getHome());
            senderAddress.setPincode(placeOrderDTO.getSender().getPincode());
            orders.setSender(senderAddress);

            Address reciverAddress=new Address();
            reciverAddress.setArea(placeOrderDTO.getReciver().getArea());
            reciverAddress.setPhone(placeOrderDTO.getReciver().getPhone());
            reciverAddress.setHome(placeOrderDTO.getReciver().getHome());
            reciverAddress.setPincode(placeOrderDTO.getReciver().getPincode());
            orders.setReciver(reciverAddress);
            orders.setCustomerUser(response);

            Orders savedOrder= ordersRepo.save(orders);
            ActiveOrders activeOrders = mapper.orders_To_ActiveOrders(savedOrder);
            activeOrders.setPickupAddress(savedOrder.getSender().getArea());
            activeOrders.setDropAddress(savedOrder.getReciver().getArea());
            activeOrderRepo.save(activeOrders);

             return savedOrder;
        }
        else{
           throw new RuntimeException("User is not right");
        }
    }


    @Override
    public List<ActiveOrders> getAllActiveOrders(){
        return activeOrderRepo.findAll();
    }




}
